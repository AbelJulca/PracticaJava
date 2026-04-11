package com.programming.data.domain;

import com.programming.data.domain.impl.MetodoPago;

public class PagoTransferencia extends MetodoPago {

    private String banco;

    public PagoTransferencia(String titular, String banco) {
        super(titular);
        this.banco = banco;
    }

    @Override
    public void procesarPago(double monto)
    {
        System.out.println("Pagando " + monto + " mediante transferencia bancaria. Banco: " + banco);
    }

}
