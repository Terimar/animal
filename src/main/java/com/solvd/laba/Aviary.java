package com.solvd.laba;

import com.solvd.laba.animals.Animal;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aviary aviary = (Aviary) o;
        return id == aviary.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Aviary{" +
                "id=" + id +
                '}';
    }
}