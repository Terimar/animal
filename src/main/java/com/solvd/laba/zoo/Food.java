package com.solvd.laba.zoo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return portion == food.portion && Objects.equals(type, food.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, portion);
    }

    @Override
    public String toString() {
        return "Food{" +
                "type='" + type + '\'' +
                ", portion=" + portion +
                '}';
    }
}