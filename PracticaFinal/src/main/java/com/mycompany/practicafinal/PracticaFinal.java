/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */


package com.mycompany.practicafinal;
import java.io.*;
import java.util.*;
/**
 *
 * @author Zarter
 */
public class PracticaFinal {
         private static final String ARCHIVO = "calificaciones.txt";
    
    public static void main(String[] args) {

         
Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("======= ========== ======= ======");
            System.out.println("COLEGIO DIOS ES BUENO");
            System.out.println("SISTEMA DE CALIFICACIONES");
            System.out.println("======= ======== ======= ========");
            System.out.println("1 - Registro de calificaciones");
            System.out.println("2 - Reporte calificaciones por mes");
            System.out.println("3 - Presione <ESC> para salir");
            System.out.println("====== ======== ========= =======");
            System.out.print("Elija la opcion: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1 -> registrarCalificaciones(sc);
                case 2 -> mostrarReporte();
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
            }
        } while (opcion != 3);
            
            
            
    }
    
    
    
     private static void registrarCalificaciones(Scanner sc) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            System.out.print("Matematica: ");
            int matematica = sc.nextInt();
            System.out.print("Lengua: ");
            int lengua = sc.nextInt();
            System.out.print("Naturales: ");
            int naturales = sc.nextInt();
            System.out.print("Sociales: ");
            int sociales = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            Estudiante e = new Estudiante(nombre, apellido, matematica, lengua, naturales, sociales);
            bw.write(e.toString());
            bw.newLine();

            System.out.println("Registro guardado correctamente ");
        } catch (IOException ex) {
            System.out.println("Error al guardar: " + ex.getMessage());
        }
    }
     
     private static void mostrarReporte() {
        List<Estudiante> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split("\t");
                if (datos.length >= 6) {
                    Estudiante e = new Estudiante(
                        datos[0], datos[1],
                        Integer.parseInt(datos[2]),
                        Integer.parseInt(datos[3]),
                        Integer.parseInt(datos[4]),
                        Integer.parseInt(datos[5])
                    );
                    lista.add(e);
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al leer archivo: " + ex.getMessage());
        }

        // Ordenar por apellido
        lista.sort(Comparator.comparing(Estudiante::getApellido));

        System.out.println("==============================================");
        System.out.println("Nombre\tApellido\tMat\tLen\tNat\tSoc\tPromedio\tLiteral");
        System.out.println("==============================================");
        for (Estudiante e : lista) {
            System.out.println(e);
        }
        System.out.println("Total de estudiantes: " + lista.size());

     }
}