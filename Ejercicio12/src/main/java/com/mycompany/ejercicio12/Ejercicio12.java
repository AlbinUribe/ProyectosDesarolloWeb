/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio12;

/**
 *
 * @author Zarter
 */
public class Ejercicio12 {

    public static void main(String[] args) {
       
        Perro perro = new Perro("Firulais", "Labrador", "Canino", "01/01/2020", 25.5f, "Parque Central");
        
        Gato gato = new Gato("Misu", "Siames", "Felino", "15/03/2021", 5.2f, 1.2);

        System.out.println("=== Datos del Perro ===");
        perro.mostrarDatos();
        perro.comunicarse();
        perro.comer();

        System.out.println("\n=== Datos del Gato ===");
        gato.mostrarDatos();
        gato.comunicarse();
        gato.comer();
    }
    
    }

