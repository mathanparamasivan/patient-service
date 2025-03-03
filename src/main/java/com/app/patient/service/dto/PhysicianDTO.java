package com.app.patient.service.dto;

import java.util.Objects;

public class PhysicianDTO {
    private Long id;
    private String name;
    private int age;
    private int experienceInYears;
    private String specialisation;
    private long salary;

    public PhysicianDTO(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperienceInYears() {
        return experienceInYears;
    }

    public void setExperienceInYears(int experienceInYears) {
        this.experienceInYears = experienceInYears;
    }

    public String getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PhysicianDTO that = (PhysicianDTO) o;
        return id == that.id && age == that.age && experienceInYears == that.experienceInYears && salary == that.salary && Objects.equals(name, that.name) && Objects.equals(specialisation, that.specialisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, experienceInYears, specialisation, salary);
    }
}
