package com.zhilyuk.task3.car;

import com.zhilyuk.task3.parking.Parking;
import com.zhilyuk.task3.parkingspot.ParkingSpot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Callable<Boolean> {
    private static final Logger logger = LogManager.getLogger();
    private String carNumber;
    ReentrantLock lock = new ReentrantLock();
    public static final long TIME_OUT = 100;

    @Override
    public Boolean call() {
        Parking parking = Parking.getInstance();
        for (ParkingSpot parkingSpot : parking.getParking()) {
            if (parkingSpot.tryTake(this.carNumber, TIME_OUT)) {
                return true;
            }
        }
        return false;
    }
}
