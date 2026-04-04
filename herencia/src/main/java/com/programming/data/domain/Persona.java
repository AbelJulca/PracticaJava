package com.programming.data.domain;

public class Persona {
    private String name;
    private int age;
    private String fullName;

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
        this.fullName = name + " " + age; // Ejemplo de cómo se podría usar fullName
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

    public String getFullName() {
        return fullName;
    }

     public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void saludar(){
        System.out.println("Hola, mi nombre es " + name + " y tengo " + age + " años.");
    }
}
