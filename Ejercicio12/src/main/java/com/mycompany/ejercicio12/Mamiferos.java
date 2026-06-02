/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio12;

/**
 *
 * @author Zarter
 */
public class Mamiferos implements IMamiferos{
    
    //Los atributos
    private String nombre;
    private String raza;
    private String tipoAnimal;
    private String fechaNacimiento;
    private float peso;
    
    //El Constructor
     public Mamiferos(String nombre, String raza, String tipoAnimal, String fechaNacimiento, float peso) {
        this.nombre = nombre;
        this.raza = raza;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }
      public void comer() {
        System.out.println(nombre + " esta comiendo.");
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    @Override
    public void comunicarse() {
        
        System.out.println("Se comunica");
        
          }
    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Tipo: " + tipoAnimal);
        System.out.println("Fecha Nacimiento: " + fechaNacimiento);
        System.out.println("Peso: " + peso + " libras");
    }
    
}
