/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicafinal;

/**
 *
 * @author Zarter
 */
public class Estudiante {

    private String nombre;
    private String apellido;
    private int matematica;
    private int lengua;
    private int naturales;
    private int sociales;
    
    
    public Estudiante(String nombre, String apellido, int matematica, int lengua, int naturales, int sociales) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matematica = matematica;
        this.lengua = lengua;
        this.naturales = naturales;
        this.sociales = sociales;
    }
    
    public double calcularPromedio() {
        return (matematica + lengua + naturales + sociales) / 4.0;
    }

    public String obtenerLiteral() {
        double promedio = calcularPromedio();
        if (promedio >= 90) return "A";
        else if (promedio >= 80) return "B";
        else if (promedio >= 70) return "C";
        else return "D";
    }
    @Override
    public String toString() {
        return nombre + "\t" + apellido + "\t" +
               matematica + "\t" + lengua + "\t" +
               naturales + "\t" + sociales + "\t" +
               calcularPromedio() + "\t" + obtenerLiteral();
    }

    public String getApellido() {
        return apellido;
    }
    
}
