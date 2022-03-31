package com.solvd.laba;

import com.solvd.laba.exceptions.LimitAviaryException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Set;

public class Zoo {

    private static final Logger LOGGER = LogManager.getLogger(Zoo.class);

    private String name;
    private int maxCageCount;
    private Set<Aviary> aviaryList;

    public Zoo () {}

    public Zoo(String name, int maxCageCount, Set<Aviary> aviaryList) {
        this.name = name;
        this.maxCageCount = maxCageCount;
        this.aviaryList = aviaryList;
    }

    public Zoo(String name, int maxCageCount) {
        this.name = name;
        this.maxCageCount = maxCageCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxCageCount() {
        return maxCageCount;
    }

    public void setMaxCageCount(int maxCageCount) {
        this.maxCageCount = maxCageCount;
    }

    public int getCountOfAvailableAviaries() {
        int aviariesCount = 0;
        if (!aviaryList.isEmpty()) {
            aviariesCount = aviaryList.size();
        }
        int freeAviariesCount = maxCageCount - aviariesCount;
        LOGGER.info("At this moment there are only " + freeAviariesCount + " free cages");
        return freeAviariesCount;
    }

    public Set<Aviary> getAviaryList() {
        return aviaryList;
    }

    public void setAviaryList(Set<Aviary> aviaries) throws LimitAviaryException {
        if (aviaries.size() > maxCageCount) {
            throw new LimitAviaryException("Sorry, our zoo can not have more aviaries than " + maxCageCount);
        }
        this.aviaryList = aviaries;
        LOGGER.info("there is free space for building new aviaries in Zooland: " + (maxCageCount - aviaries.size()));
    }
}