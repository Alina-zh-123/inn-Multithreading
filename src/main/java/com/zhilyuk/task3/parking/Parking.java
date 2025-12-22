package com.zhilyuk.task3.parking;

import com.zhilyuk.task3.parkingspot.ParkingSpot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Parking {
    public static final Logger logger = LogManager.getLogger();
    private static final Parking INSTANCE = new Parking();
    private final int capacity = 500;
    private ParkingSpot[] parking;

    private Parking() {
        this.parking = new ParkingSpot[capacity];
        for (int i = 0; i < parking.length; i++) {
            parking[i] = new ParkingSpot();
            parking[i].setTaken(false);
        }
    }

    public static Parking getInstance() {
        return INSTANCE;
    }

    public int getCapacity() {
        return capacity;
    }

    public ParkingSpot[] getParking() {
        return parking;
    }
}
