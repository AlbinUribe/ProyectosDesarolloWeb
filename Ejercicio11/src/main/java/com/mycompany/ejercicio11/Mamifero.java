/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio11;

/**
 *
 * @author Zarter
 */
public class Mamifero {

    String nombre;
    String raza;
    String fechaNacimiento;
    float peso;

    // Constructor
    public Mamifero(String nombre, String raza, String fechaNacimiento, float peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }

    // Métodos
    public void comer() {
        System.out.println(nombre + " esta comiendo.");
    }

    public void comunicarse() {
        System.out.println("El mamífero hace un sonido.");
    }
}
    

