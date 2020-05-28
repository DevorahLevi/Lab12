package edu.ti.caih313.collections.dataobj;

import java.time.LocalDate;
import java.time.Period;

public class Person {
    private Name name;
    private Gender gender;

    //private EmailAddress emailAddress;

    //age in years
    //TODO -- replace by Date birthday, and getAge that calculates age
    private LocalDate birthDate;

    public enum Gender {MALE, FEMALE}

    public Person(Name name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        Period ageNow = Period.between(birthDate, LocalDate.now());
        return ageNow.getYears();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", gender=" + gender +
                ", birthDate=" + birthDate
                + "}";
    }
}
