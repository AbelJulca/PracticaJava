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

        System.out.println("---------------------------------------------------------");
        CuentaBancaria cuentaBancaria = new CuentaBancaria("Carlos", 1000);
        cuentaBancaria.depositar(500);
        cuentaBancaria.retirar(200);
        //cuentaBancaria.mostrarSaldo();

        // Declaramos una variable de tipo Persona (clase)
        // Una clase es una plantilla o molde que define cómo serán los objetos.
        Persona persona1;

        // Creamos un objeto de tipo Persona utilizando el constructor por defecto
        //Un objeto es una instancia de una clase. En Java, las variables de objetos no guardan objetos, guardan referencias.
        //Estás guardando una referencia (dirección de memoria). Ejemplo:

        persona1 = new Persona();
        // Ahora persona1 es una referencia a un objeto de tipo Persona en memoria.
        Persona persona2 = persona1;
        // persona2 también es una referencia al mismo objeto de tipo Persona en memoria.
        // No se ha creado un nuevo objeto, sino que ambas variables apuntan al mismo objeto.

        persona1.setEdad(12);
        persona1.setNombre("Ana");
        System.out.println("---------------------------------------------------------");
        System.out.println("Persona 2: " + persona2.getNombre() + ", Edad: " + persona2.getEdad());
    }

}