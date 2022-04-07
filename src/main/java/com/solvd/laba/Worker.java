package com.solvd.laba;

import java.util.Objects;

public class Worker {

    private String firstName;
    private String lastName;
    private String position;

    public Worker() {
    }

    public Worker(String firstName, String lastName, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(firstName, worker.firstName) && Objects.equals(lastName, worker.lastName) && Objects.equals(position, worker.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, position);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}