package com.solvd.laba.zoo.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Hawk {

    private static final Logger LOGGER = LogManager.getLogger(Hawk.class);

    private final int wing = 2;

    public final void myFood() {
        LOGGER.info("I'm eat only meat");
    }
}
