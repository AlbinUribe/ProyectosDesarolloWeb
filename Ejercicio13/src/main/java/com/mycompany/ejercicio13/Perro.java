/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio13;

/**
 *
 * @author Zarter
 */
public class Perro extends Mamiferos{

 private String lugarEntrenamiento;

    public Perro(String nombre, String raza, String tipoAnimal, String fechaNacimiento, float peso, String lugarEntrenamiento) {
        super(nombre, raza, tipoAnimal, fechaNacimiento, peso);
        this.lugarEntrenamiento = lugarEntrenamiento;
    }

    @Override
    public void comer() {
        System.out.println(nombre + " esta comiendo purina.");
    }

    @Override
    public String tipoAnimal() {
        return "Canino";
    }

    @Override
    public void comunicarse() {
        System.out.println("Guau guau ");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Lugar de entrenamiento: " + lugarEntrenamiento);
    }
}
    
    
