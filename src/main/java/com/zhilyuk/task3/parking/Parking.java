package com.zhilyuk.task3.parking;

import com.zhilyuk.task3.parkingspot.ParkingSpot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;

public class Parking {
    public static final Logger logger = LogManager.getLogger();
    private static final Parking INSTANCE = new Parking();
    private static final int PARKING_CAPACITY = 5;
    private ArrayList<ParkingSpot> parking;

    private Parking() {
        parking = new ArrayList<>();
        for (int i = 0; i < PARKING_CAPACITY; i++) {
            parking.add(new ParkingSpot());
        }
    }

    public static Parking getInstance() {
        return INSTANCE;
    }

    public ArrayList<ParkingSpot> getParking() {
        return parking;
    }
}
