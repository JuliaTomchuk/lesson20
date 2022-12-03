package org.lesson20.entity;

import java.util.Objects;

public class Student {

   private int id;
   private String firstName;
    private String secondName;
    private City city;
    public Student(int id, String firstName, String secondName,City city){
        this.id = id;
        this.firstName=firstName;
        this.secondName = secondName;
        this.city = city;
    }
    public Student(){}

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getId() == student.getId() && getFirstName().equals(student.getFirstName()) && getSecondName().equals(student.getSecondName()) && getCity().equals(student.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getSecondName(), getCity());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", city=" + city +
                '}';
    }
}
