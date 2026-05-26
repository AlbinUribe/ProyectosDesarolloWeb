/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio6;

import java.util.Scanner;

/**
 *
 * @author Zarter
 */
public class Ejercicio6 {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int[] numeros = new int[10];
        int suma = 0;
        double promedio;

        for(int i = 0; i < 10; i++)
        {
            System.out.print("Digite un numero ");
            numeros[i] = sc.nextInt();

            suma += numeros[i];
        }

        promedio = suma / 10.0;

        System.out.println("La suma es " + suma);
        System.out.println("El promedio es " + promedio);
    }
}
