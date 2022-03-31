package com.solvd.laba;

public class Food {

    private String type;
    private int portion;

    public Food () {}

    public Food (String type, int portion) {
        this.type = type;
        this.portion = portion;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPortion() {
        return portion;
    }

    public void setPortion(int portion) {
        this.portion = portion;
    }
}