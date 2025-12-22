package com.zhilyuk.task3.main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger();
    private static final String path = "input.txt";

    public static void main(String[] args) {
        try {
            List<String> carNumbers = Files.readAllLines(Paths.get(path));



        } catch (IOException e) {
        }
    }
}
