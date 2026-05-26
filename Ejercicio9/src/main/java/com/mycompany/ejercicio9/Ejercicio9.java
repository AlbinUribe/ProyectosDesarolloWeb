/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio9;

import java.util.Scanner;

/**
 *
 * @author Zarter
 */
public class Ejercicio9 {

    public static void main(String[] args) {
           Scanner sc = new Scanner(System.in);

        int[] numeros = new int[10];
        int buscado;
        boolean encontrado = false;

        for(int i = 0; i < 10; i++)
        {
            System.out.print("Digite un numero: ");
            numeros[i] = sc.nextInt();
        }

        System.out.print("Digite el numero a buscar: ");
        buscado = sc.nextInt();

        for(int i = 0; i < 10; i++)
        {
            if(numeros[i] == buscado)
            {
                System.out.println("Numero encontrado en la posicion: " + i);
                encontrado = true;
            }
        }

        if(encontrado == false)
        {
            System.out.println("Numero no encontrado");
        }
    }
}
