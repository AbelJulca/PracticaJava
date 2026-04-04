package com.programming.data;

import com.programming.data.domain.Empleado;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creando un objeto de la clase Empleado
        Empleado empleado = new Empleado("Juan", 30, 50000);

        System.out.println("-------------------------------------------------------");

        //Mostrando la información del empleado
        empleado.mostarInformacion();
        empleado.saludar();
    }
}