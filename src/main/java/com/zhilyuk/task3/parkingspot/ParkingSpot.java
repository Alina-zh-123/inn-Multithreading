package com.zhilyuk.task3.parkingspot;

import com.zhilyuk.task3.car.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpot {
    public static final Logger logger = LogManager.getLogger();
    private boolean isTaken;
    private String carNumberTakenBy;
    private final ReentrantLock lock = new ReentrantLock();

    public boolean getTaken() {
        return isTaken;
    }

    public String getCarNumberTakenBy() {
        return carNumberTakenBy;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public void setCarNumberTakenBy(String carNumberTakenBy) {
        this.carNumberTakenBy = carNumberTakenBy;
    }

    public boolean tryTake(String carNumber, long timeout) {
        lock.lock();
        try {
            if (!this.getTaken()) {
                this.setTaken(true);
                this.setCarNumberTakenBy(carNumber);
                return true;
            }
        } finally {
            lock.unlock();
        }
        return false;
    }
}
