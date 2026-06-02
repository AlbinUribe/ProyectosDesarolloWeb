/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio12;

/**
 *
 * @author Zarter
 */
public class Perro extends Mamiferos{
    private String LugarEntrenamiento;
    
    public Perro(String nombre, String raza, String tipoAnimal, String fechaNacimiento, float peso, String parque_Central) {
        super(nombre, raza, tipoAnimal, fechaNacimiento, peso);
    }
    @Override
    public void comunicarse() {
        System.out.println("Guau guau ?");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Lugar de entrenamiento: " + LugarEntrenamiento);
    }
    
}
