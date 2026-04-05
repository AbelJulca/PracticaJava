package com.programming.data.domain;

public class Auto implements Vehiculo{
    @Override
    public void arrancar() {
        System.out.println("El auto está arrancando.");
    }
}
