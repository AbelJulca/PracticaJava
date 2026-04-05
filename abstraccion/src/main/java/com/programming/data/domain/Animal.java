package com.programming.data.domain;

public abstract class Animal {
    public abstract void hacerSonido();

    public void dormir() {
        System.out.println("El animal está durmiendo.");
    }
}
