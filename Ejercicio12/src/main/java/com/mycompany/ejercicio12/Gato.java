/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio12;

/**
 *
 * @author Zarter
 */
public class Gato extends Mamiferos{
    private double alturaSalto;
    
    public Gato(String nombre, String raza, String tipoAnimal, String fechaNacimiento, float peso, double par1) {
        super(nombre, raza, tipoAnimal, fechaNacimiento, peso);
    }
    
    @Override
    public void comunicarse() {
        System.out.println("Miau miau ");
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Altura de salto: " + alturaSalto + " metros");
    }
    
}
