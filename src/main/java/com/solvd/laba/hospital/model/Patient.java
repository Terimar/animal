package com.solvd.laba.hospital.model;

public class Patient extends Person {

    private Integer age;
    private DiseaseHistory diseaseHistory;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public DiseaseHistory getDiseaseHistory() {
        return diseaseHistory;
    }

    public void setDiseaseHistory(DiseaseHistory diseaseHistory) {
        this.diseaseHistory = diseaseHistory;
    }
}
