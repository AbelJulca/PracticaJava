package com.programming.data;

import com.programming.data.domain.Animal;
import com.programming.data.domain.Gato;
import com.programming.data.domain.Perro;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //El polimorfismo significa
        //“Un mismo metodo puede comportarse de diferentes formas”

        //Polimorfismo = muchas formas
        //Se basa en herencia
        //Usa sobrescritura (@Override)
        //Java decide en tiempo de ejecución

        Animal a1 = new Gato("Gato", 3);
        Animal a2 = new Perro("Perro", 5);

        a1.hacerSonido();
        a2.hacerSonido();
    }
}
