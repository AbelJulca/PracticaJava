package com.programming.data.domain.impl;

import com.programming.data.domain.Pago;

public abstract class MetodoPago implements Pago {
    private String titular;

    public MetodoPago(String titular) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no puede ser nulo o vacío");
        }
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public void mostrarTitular() {
        System.out.println("Titular: " + titular);
    }
}
