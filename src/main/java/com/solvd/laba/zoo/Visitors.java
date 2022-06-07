package com.solvd.laba.zoo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Visitors {

    private static final Logger LOGGER = LogManager.getLogger(Visitors.class);

    private static int count;
    private static int maxCount;

    static {
        maxCount = 150;
    }

    public static void totalVisitors() {
        count++;
        LOGGER.info("Current amount visitors - " + count);
    }
}