/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio7;

import java.util.Scanner;

/**
 *
 * @author Zarter
 */
public class Ejercicio7 {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);

        int[] numeros = new int[10];

        for(int i = 0; i < 10; i++)
        {
            System.out.print("Digite un numero ");
            numeros[i] = sc.nextInt();
        }

        int mayor = numeros[0];
        int menor = numeros[0];

        for(int i = 1; i < 10; i++)
        {
            if(numeros[i] > mayor)
            {
                mayor = numeros[i];
            }

            if(numeros[i] < menor)
            {
                menor = numeros[i];
            }
        }

        System.out.println("El numero mayor es: " + mayor);
        System.out.println("El numero menor es: " + menor);
    }
}
