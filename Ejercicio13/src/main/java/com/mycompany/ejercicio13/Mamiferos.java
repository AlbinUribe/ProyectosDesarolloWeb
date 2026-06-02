/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio13;

/**
 *
 * @author Zarter
 */
abstract class Mamiferos {
    
    protected String nombre;
    protected String raza;
    protected String tipoAnimal;
    protected String fechaNacimiento;
    protected float peso;
    
    public Mamiferos(String nombre, String raza, String tipoAnimal, String fechaNacimiento, float peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }
    
    public abstract void comer();
    public abstract String tipoAnimal();
    public abstract void comunicarse();
    
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Tipo: " + tipoAnimal);
        System.out.println("Fecha Nacimiento: " + fechaNacimiento);
        System.out.println("Peso: " + peso + " kg");
    }
    
    
}
