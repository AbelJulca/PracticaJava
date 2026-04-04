package com.programming.data.domain;

public class Animal {
    private String description;
    private int Age;

    public Animal(String description, int age) {
        this.description = description;
        Age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}
