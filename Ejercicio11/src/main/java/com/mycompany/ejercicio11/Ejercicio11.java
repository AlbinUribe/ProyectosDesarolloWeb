/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio11;

import java.util.Scanner;

/**
 *
 * @author Zarter
 */
public class Ejercicio11 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        // Perro
        System.out.println("Escriba los datos del perro");

        System.out.print("Nombre: ");
        String nombrePerro = sc.nextLine();

        System.out.print("Raza: ");
        String razaPerro = sc.nextLine();

        System.out.print("Fecha de nacimiento: ");
        String fechaPerro = sc.nextLine();

        System.out.print("Peso: ");
        float pesoPerro = sc.nextFloat();
        sc.nextLine();

        System.out.print("Lugar de entrenamiento: ");
        String lugar = sc.nextLine();

        Perro perro = new Perro(
                nombrePerro,
                razaPerro,
                fechaPerro,
                pesoPerro,
                lugar
        );

        System.out.println();

        // Gato
        System.out.println("Escriba los datos del gato");

        System.out.print("Nombre: ");
        String nombreGato = sc.nextLine();

        System.out.print("Raza: ");
        String razaGato = sc.nextLine();

        System.out.print("Fecha de nacimiento: ");
        String fechaGato = sc.nextLine();

        System.out.print("Peso: ");
        float pesoGato = sc.nextFloat();

        System.out.print("Altura de salto: ");
        double altura = sc.nextDouble();

        Gato gato = new Gato(
                nombreGato,
                razaGato,
                fechaGato,
                pesoGato,
                altura
        );

        System.out.println();

        // Métodos
        perro.comer();
        perro.comunicarse();

        System.out.println();

        gato.comer();
        gato.comunicarse();

        sc.close();
        
    }
}
