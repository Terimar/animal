package com.solvd.laba;

import com.solvd.laba.animals.Animal;

public class Aviary {

    private int id;
    private Animal animal;

    public Aviary(int id) {
        this.id = id;
    }

    public Aviary(int id, Animal animal) {
        this.id = id;
        this.animal = animal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }


}