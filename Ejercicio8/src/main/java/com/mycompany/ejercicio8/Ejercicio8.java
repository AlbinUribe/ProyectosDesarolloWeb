/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio8;

import java.util.Scanner;

/**
 *
 * @author Zarter
 */
public class Ejercicio8 {

    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);

        int[] numeros = new int[10];
        int divisor;

        for(int i = 0; i < 10; i++)
        {
            System.out.print("Digite un numero: ");
            numeros[i] = sc.nextInt();
        }

        System.out.print("Digite el divisor: ");
        divisor = sc.nextInt();

        System.out.println("Multiplos de " + divisor + ":");

        for(int i = 0; i < 10; i++)
        {
            if(numeros[i] % divisor == 0)
            {
                System.out.println(numeros[i]);
            }
        }
    }
}
