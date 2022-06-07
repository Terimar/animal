package com.solvd.laba.hospital.model;

import java.util.List;

public class Employee extends Person {

    private Position position;
    private Integer qualification;
    private Specialization specialization;
    private List<Appointment> appointments;

    public enum Position {
        DOCTOR, NURSE, DEPARTMENT_HEAD
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getQualification() {
        return qualification;
    }

    public void setQualification(Integer qualification) {
        this.qualification = qualification;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
