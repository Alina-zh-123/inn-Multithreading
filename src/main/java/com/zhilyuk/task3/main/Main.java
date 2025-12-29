package com.zhilyuk.task3.main;
import com.zhilyuk.task3.car.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String path = "data/input.txt";
    private static final int CAR_NUMBER = 10;

    public static void main(String[] args) {
        try {
            List<String> carNumbers = Files.readAllLines(Paths.get(path));
            List<Future<Boolean>> futures = new ArrayList<>();
            int index = 0;

            ExecutorService service = Executors.newFixedThreadPool(CAR_NUMBER);
            for (int i = 0 ; i < CAR_NUMBER; i++) {
                Car car = new Car(carNumbers.get(index));
                Future<Boolean> future = service.submit(car);
                futures.add(future);
                index++;
            }

            service.shutdown();
        } catch (IOException e) {
            logger.error("Error input file {}", e.getMessage());
        }
    }
}
