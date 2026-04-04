package com.programming.data.domain;

public class Gato extends Animal {
    public Gato(String description, int age) {
        super(description, age);
    }

    @Override
    public void hacerSonido() {
        System.out.println("El gato hace miau");
    }

}
