package com.programming.data.domain;

public class Empleado extends Persona{

    private double salary;

    public Empleado(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    public void mostarInformacion(){
        System.out.println("Nombre: " + getName());
        System.out.println("Edad: " + getAge());
        System.out.println("Salario: " + salary);
        System.out.println("Full Name: " + getFullName());
    }

    @Override
    public void saludar() {
        System.out.println("Hola, soy un empleado. Mi nombre es " + getName()
                + ", tengo " + getAge() + " años y gano " + salary + " al año.");
    }
}
