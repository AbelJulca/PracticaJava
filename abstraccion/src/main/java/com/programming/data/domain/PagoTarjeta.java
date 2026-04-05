package com.programming.data.domain;

public class PagoTarjeta implements Pago{
    @Override
    public void realizarPago(double monto) {
        System.out.println("Realizando pago con tarjeta por un monto de: " + monto);
    }
}
