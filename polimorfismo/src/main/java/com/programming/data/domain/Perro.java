package com.programming.data.domain;

public class Perro extends Animal{
    public Perro(String description, int age) {
        super(description, age);
    }

    @Override
    public void hacerSonido() {
        System.out.println("El perro hace guau");
    }
}
