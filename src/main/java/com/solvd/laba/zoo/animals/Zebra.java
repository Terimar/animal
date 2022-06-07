package com.solvd.laba.zoo.animals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Zebra extends Animal {

    private static final Logger LOGGER = LogManager.getLogger(Zebra.class);

    public Zebra() {}

    public Zebra(int id, String type, int age, float weight){
        super(id, type, age, weight);
    }

    @Override
    public void say() {
        LOGGER.info("I am " + super.getType() + " and I will eat only herbal");
    }

    @Override
    public String toString() {
        return "Zebra (id: " + super.getId() + ", type: " + super.getType() + ", age: " + super.getAge() +
                ", weight: " + super.getWeight() + ")";
    }
}