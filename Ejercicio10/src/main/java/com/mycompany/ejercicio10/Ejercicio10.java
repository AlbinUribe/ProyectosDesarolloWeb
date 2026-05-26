/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio10;

import java.util.Scanner;

/**
 *
 * @author Zarter
 */
public class Ejercicio10 {

    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

        int[][] matriz1 = new int[3][3];
        int[][] matriz2 = new int[3][3];

        int[][] suma = new int[3][3];
        int[][] producto = new int[3][3];

        int numero;

        System.out.println("Digite los valores de la matriz 1");

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print("Posicion [" + i + "][" + j + "]: ");
                matriz1[i][j] = sc.nextInt();
            }
        }

        System.out.println("Digite los valores de la matriz 2");

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print("Posicion [" + i + "][" + j + "]: ");
                matriz2[i][j] = sc.nextInt();
            }
        }

        System.out.print("Digite el numero para multiplicar las matrices: ");
        numero = sc.nextInt();

        System.out.println("\nMatriz 1 multiplicada por " + numero);

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print((matriz1[i][j] * numero) + " ");
            }

            System.out.println();
        }

        System.out.println("\nMatriz 2 multiplicada por " + numero);

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print((matriz2[i][j] * numero) + " ");
            }

            System.out.println();
        }

        System.out.println("\nSuma de matrices");

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                suma[i][j] = matriz1[i][j] + matriz2[i][j];

                System.out.print(suma[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("\nProducto de matrices");

        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                for(int k = 0; k < 3; k++)
                {
                    producto[i][j] += matriz1[i][k] * matriz2[k][j];
                }

                System.out.print(producto[i][j] + " ");
            }

            System.out.println();
        }
    }
}
