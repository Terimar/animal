package com.solvd.laba.enums;

public enum Country {
    AUSTRALIA("Australia"),
    BRAZIL("Brazil"),
    CANADA("Canada"),
    CONGO("Congo"),
    EGYPT("Egypt"),
    ALGERIA("Algeria");

    private final String region;

    Country(String region) {
        this.region = region;
    }

    public String getRegion() {
        return region;
    }

    @Override
    public String toString() {
        return "Country{" +
                "region='" + region + '\'' +
                '}';
    }
}
