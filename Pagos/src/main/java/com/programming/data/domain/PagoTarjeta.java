package com.programming.data.domain;

import com.programming.data.domain.impl.MetodoPago;

public class PagoTarjeta extends MetodoPago {

    private String numeroTarjeta;

    public PagoTarjeta(String titular, String numeroTarjeta) {
        super(titular);
        this.numeroTarjeta = numeroTarjeta;
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("pagado " + monto + " con tarjeta de crédito/débito. Número de tarjeta: " + numeroTarjeta);
    }
}
