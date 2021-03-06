package com.solvd.laba.hospital.model;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Department {

    private Long id;

    @XmlAttribute(name = "title")
    private String title;
    private Employee departmentHead;

    @XmlElementWrapper(name = "employees")
    @XmlElement(name="employee")
    private List<Employee> employees;
    private List<Ward> wards;
    private List<Equipment> equipments;
    private List<Medication> medications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(Employee employee) {
        departmentHead = employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Ward> getWards() {
        return wards;
    }

    public void setWards(List<Ward> wards) {
        this.wards = wards;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipmentList) {
        this.equipments = equipmentList;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    @Override
    public String toString() {
        return "Department{" +
                " id=" + id +
                ", title='" + title + '\'' +
                ", wards=" + wards +
                '}';
    }
}
