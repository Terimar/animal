package com.solvd.laba.animals;

import com.solvd.laba.Food;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Animal {

    private static final Logger LOGGER = LogManager.getLogger(Animal.class);

    private int id;
    private String type;
    private int age;
    private float weight;
    private boolean isEaten;

    public Animal () {}

    public Animal(int id, String type, int age, float weight){
        this.id = id;
        this.type = type;
        this.age = age;
        this.weight = weight;
        isEaten = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isEaten() {
        return isEaten;
    }

    public void setEaten(boolean eaten) {
        isEaten = eaten;
    }

    public abstract void say();

    public void eat(Food food) {
        String foodType = food.getType();
        int foodPortion = food.getPortion();

        if (isEaten) {
            LOGGER.info("Sorry, I was eaten already today");
        } else {
            if (type.equals("herbivore") && foodType.equals("Herbal")) {
                isEaten = true;
                food.setPortion(foodPortion - 1);
                LOGGER.info("Thank you, only " + food.getPortion() + " portions are left");
            } else if (type.equals("carnivore") && foodType.equals("Meat")) {
                isEaten = true;
                food.setPortion(foodPortion - 1);
                LOGGER.info("Thank you, only " + food.getPortion() + " portions are left");
            } else {
                LOGGER.info("Sorry, I don't eat this food");
            }
        }
    }

    @Override
    public int hashCode() {
        int x = type.equals("herbivore") ? 2 : 3;
        int weight = (int) getWeight();
        int age = getAge();
        return x * weight * age;
    }

    @Override
    public boolean equals(Object object) {
        return hashCode() == object.hashCode();
    }
}