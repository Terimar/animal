package com.solvd.laba.enums;

public enum AnimalType {
    LION("Lion"),
    TIGER("Tiger"),
    ZEBRA("Zebra"),
    GIRAFFE("Giraffe"),
    HAWK("Hawk");

    private final String type;

    AnimalType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "AnimalType{" +
                "type='" + type + '\'' +
                '}';
    }
}
