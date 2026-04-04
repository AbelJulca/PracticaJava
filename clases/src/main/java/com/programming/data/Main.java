package com.programming.data;

import com.programming.data.domain.CuentaBancaria;
import com.programming.data.domain.Persona;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setEdad(11);

        p1.saludar();

        Persona p2 = new Persona("Maria", 25);
        p2.saludar();

        CuentaBancaria cuentaBancaria = new CuentaBancaria("Carlos", 1000);
        cuentaBancaria.depositar(500);
        cuentaBancaria.retirar(200);
        cuentaBancaria.mostrarSaldo();

    }
}