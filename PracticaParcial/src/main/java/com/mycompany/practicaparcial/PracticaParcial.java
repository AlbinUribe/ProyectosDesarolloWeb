/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicaparcial;

/**
 *
 * @author Zarter
 */
import java.io.*;
import java.util.*;

public class PracticaParcial {
    
    private static final String ARCHIVO = "calificaciones.txt";

    public static void main(String[] args) {
        
Scanner sc = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("============================================================================================");
            System.out.println("COLEGIO DIOS ES BUENO");
            System.out.println("SISTEMA DE CALIFICACIONES");
            System.out.println("============================================================================================");
            System.out.println("1 - Registro de calificaciones");
            System.out.println("2 - Reporte calificaciones por mes");
            System.out.println("3 - Salir");
            System.out.println("============================================================================================");
            System.out.print("Elija la opcion: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                
                case 1 -> registrarCalificaciones(sc);
                case 2 -> mostrarReporte(sc);
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opcion invalida.");
                
            }
        } 
        while (opcion != 3);
    }

    private static int pedirNota(Scanner sc, String materia) {
        
        int nota;
        
        do {
            
            System.out.print(materia + ": ");
            while (!sc.hasNextInt()) {
                System.out.println("Debe ingresar un numero valido.");
                sc.next(); 
                
            }
            
            nota = sc.nextInt();
            if (nota < 0 || nota > 100) {
                
                System.out.println("La nota debe estar entre 0 y 100.");
                
            }
        } 
        while (nota < 0 || nota > 100);
        return nota;
    }

    private static String pedirMes(Scanner sc) {
        
        List<String> mesesValidos = Arrays.asList(
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
                
        );

        String mes;
        do {
            System.out.print("Mes: ");
            mes = sc.nextLine().trim();
            if (!mesesValidos.contains(mes)) {
                System.out.println("Mes invalido. Debe ser uno de: " + mesesValidos);
            }
        } while (!mesesValidos.contains(mes));

        return mes;
    }

    private static void registrarCalificaciones(Scanner sc) {
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            
            System.out.print("Apellido: ");
            String apellido = sc.nextLine();
            
            System.out.print("Curso: ");
            String curso = sc.nextLine();

            System.out.println("Meses disponibles: Enero, Febrero, Marzo, Abril...");
            
            String mes = pedirMes(sc);
            

            int matematica = pedirNota(sc, "Matematica");
            int lengua = pedirNota(sc, "Lengua");
            int naturales = pedirNota(sc, "Naturales");
            int sociales = pedirNota(sc, "Sociales");
            
            sc.nextLine(); 

            Estudiante e = new Estudiante(nombre, apellido, matematica, lengua, naturales, sociales, curso, mes);
            
            bw.write(nombre + "\t" + apellido + "\t" + curso + "\t" + mes + "\t" +
                     matematica + "\t" + lengua + "\t" + naturales + "\t" + sociales);
            
            bw.newLine();

            System.out.println("Registro guardado correctamente");
            
        } catch (IOException ex) {
            
            System.out.println("Error al guardar: " + ex.getMessage());
        }
    }

    private static void mostrarReporte(Scanner sc) {
        
        System.out.println("Meses disponibles: Enero, Febrero, Marzo, Abril...");
        String mesReporte = pedirMes(sc);

        List<Estudiante> lista = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            
            String linea;
            
            while ((linea = br.readLine()) != null) {
                
                String[] datos = linea.split("\t");
                
                if (datos.length >= 8) {
                    
                    Estudiante e = new Estudiante(
                            
                        datos[0], datos[1],
                        Integer.parseInt(datos[4]),
                        Integer.parseInt(datos[5]),
                        Integer.parseInt(datos[6]),
                        Integer.parseInt(datos[7]),
                        datos[2], datos[3]
                            
                    );
                    
                    if (e.getMes().equalsIgnoreCase(mesReporte)) {
                        lista.add(e);
                        
                        
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al leer archivo: " + ex.getMessage());
        }

        lista.sort(Comparator.comparing(Estudiante::getApellido));

        System.out.println("============================================================================================");
        
        System.out.printf("%-10s %-10s %-6s %-10s %-5s %-5s %-5s %-5s %-10s %-8s%n",
                "Nombre", "Apellido", "Curso", "Mes", "Mat", "Len", "Nat", "Soc", "Promedio", "Literal");
        
        
        System.out.println("============================================================================================");

        double sumaPromedios = 0;
        
        for (Estudiante e : lista) {
            
            
            System.out.printf("%-10s %-10s %-6s %-10s %-5d %-5d %-5d %-5d %-10.2f %-8s%n",
                    e.getNombre(), e.getApellido(), e.getCurso(), e.getMes(),
                    e.getMatematica(), e.getLengua(), e.getNaturales(), e.getSociales(),
                    e.calcularPromedio(), e.obtenerLiteral());{
            
        }
            sumaPromedios += e.calcularPromedio();
            
            
        }

        System.out.println("Total de estudiantes: " + lista.size());
        if (!lista.isEmpty()) {
            System.out.printf("Promedio general del mes %s: %.2f%n", mesReporte, (sumaPromedios / lista.size()));
            
        }
        
        System.out.println("============================================================================================");
        
        
        
    }
}

