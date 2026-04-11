package com.programming.data.domain;

import com.programming.data.domain.impl.MetodoPago;

public class PagoEfectivo extends MetodoPago {
    public PagoEfectivo(String titular) {
        super(titular);
    }

    @Override
    public void procesarPago(double monto) {
        System.out.println("Pagando " + monto + " en efectivo");
    }
}
