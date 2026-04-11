package com.programming.data;

import com.programming.data.domain.Pago;
import com.programming.data.domain.PagoEfectivo;
import com.programming.data.domain.PagoTarjeta;
import com.programming.data.domain.PagoTransferencia;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void ejecutarPago(Pago pago, double monto) {
        pago.procesarPago(monto);
    }

    public static void main(String[] args) {
        Pago p1 = new PagoTarjeta("Abel", "1234-5678");
        Pago p2 = new PagoEfectivo("Maria");
        Pago p3 = new PagoTransferencia("Luis", "TTB");

        ejecutarPago(p1, 100);
        ejecutarPago(p2, 50);
        ejecutarPago(p3, 200);
    }
}