package com.programming.data;

import com.programming.data.domain.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // La abstracción consiste en:
        //
        //Mostrar solo lo esencial y ocultar los detalles de implementación.
        //En Java, la abstracción se logra a través de:
        //1. Clases abstractas: Son clases que no pueden ser instanciadas
        // y pueden contener métodos abstractos (sin implementación) y métodos concretos (con implementación).
        //2. Interfaces: Son contratos que definen métodos sin implementación.
        // Las clases que implementan una interfaz deben proporcionar la implementación
        // de todos los métodos definidos en la interfaz.
        //

        Animal a = new Perro();
        a.hacerSonido();
        a.dormir();

        //Interface
        System.out.println("------------------------------");

        Vehiculo v = new Auto();
        v.arrancar();

        System.out.println("------------------------------");

        Pago p = new PagoEfectivo();
        p.realizarPago(100.0);


    }
}