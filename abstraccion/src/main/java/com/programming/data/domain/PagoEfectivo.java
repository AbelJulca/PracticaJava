package com.programming.data.domain;

public class PagoEfectivo implements Pago{
    @Override
    public void realizarPago(double monto) {
        System.out.println("Realizando pago en efectivo por un monto de: " + monto);
    }
}
