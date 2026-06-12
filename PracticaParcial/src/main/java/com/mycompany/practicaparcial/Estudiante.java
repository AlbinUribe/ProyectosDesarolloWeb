/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaparcial;

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
    private String curso;
    private String mes;

    public Estudiante(String nombre, String apellido, int matematica, int lengua, int naturales, int sociales, String curso, String mes) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.matematica = matematica;
        this.lengua = lengua;
        this.naturales = naturales;
        this.sociales = sociales;
        this.curso = curso;
        this.mes = mes;
        
    }

    public double calcularPromedio() {
        
        return (matematica + lengua + naturales + sociales) / 4.0;
        
    }

    public String obtenerLiteral() {
        double promedio = calcularPromedio();
        if (promedio >= 90) return "A";
        else if (promedio >= 80) return "B";
        else if (promedio >= 70) return "C";
        else if (promedio >= 60) return "D";
        else return "F";
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCurso() { return curso; }
    public String getMes() { return mes; }
    public int getMatematica() { return matematica; }
    public int getLengua() { return lengua; }
    public int getNaturales() { return naturales; }
    public int getSociales() { return sociales; }
}
