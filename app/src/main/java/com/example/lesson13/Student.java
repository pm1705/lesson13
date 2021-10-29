package com.example.lesson13;

public class Student {
    String name;
    String surname;
    String phone;
    String birth;

    public Student(String name, String surname, String phone, String birth) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }
}
