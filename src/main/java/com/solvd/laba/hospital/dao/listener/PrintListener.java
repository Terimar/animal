package com.solvd.laba.hospital.dao.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PrintListener implements DbEventListener {

    private static final Logger LOGGER = LogManager.getLogger(PrintListener.class);

    @Override
    public void onEvent(String message) { LOGGER.info("Message from listener: " + message);
    }
}
