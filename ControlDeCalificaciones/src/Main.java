import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //I-P-O
        //Input
        String nombreAlumno = leerTextoNoVacio("Ingresa tu nombre: ", sc);
        double calParcial1 = leerDoubleEnRango("Ingresa la calificacion del parcial 1: ", sc, 0, 100);
        double calParcial2 = leerDoubleEnRango("Ingresa la calificacion del parcial 2: ", sc, 0, 100);
        double calParcial3 = leerDoubleEnRango("Ingresa la calificacion del parcial 3: ", sc, 0, 100);
        int asistencia = leerIntEnRango("Ingresa el porcentaje de tu asistencia: ", sc, 0, 100);
        boolean entregoProyecto = leerBoolean("Ingresa si entregaste proyecto (true-false): ", sc);

        //Process
        double promedio = GradeService.calcularPromedio(calParcial1, calParcial2, calParcial3);
        double calificacionFinal = GradeService.calcularFinal(promedio, asistencia);
        String estado = GradeService.determinarEstado(asistencia, entregoProyecto, calificacionFinal);
        //Output
        imprimirReporte(nombreAlumno, calParcial1, calParcial2, calParcial3, promedio, asistencia, entregoProyecto, calificacionFinal, estado);

    }

    public static String leerTextoNoVacio(String msg, Scanner sc) {
        String nombre;
        while (true) {
            System.out.print(msg);
            nombre = sc.nextLine();

            if (nombre.isBlank()) {
                System.out.println("Error, el nombre no puede estar vacio");
            } else {
                return nombre;
            }
        }
    }
    public static double leerDoubleEnRango(String msg, Scanner sc, double min, double max) {
        double entrada;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                entrada = sc.nextDouble();
                if (entrada >= min && entrada <= max) {
                    return entrada;
                } else {
                    System.out.println("Ingresa un entero que este entre el rango (0-100)");
                }
            } else {
                System.out.println("Ingresa un valor numerico");
                sc.next();
            }
        }
    }

    public static int leerIntEnRango(String msg, Scanner sc, int min, int max) {
        int entero;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                entero = sc.nextInt();
                if (entero >= min && entero <= max) {
                    return entero;
                } else {
                    System.out.println("Ingresa un entero que este entre el rango (0-100)");
                }
            } else {
                System.out.println("Ingresa un valor numerico");
                sc.next();
            }
        }
    }
    public static boolean leerBoolean(String msg, Scanner sc) {
        boolean esBoolean;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextBoolean()) {
                esBoolean = sc.nextBoolean();
                sc.nextLine();
                return esBoolean;
            } else {
                System.out.println("Error, ingresa solo true o false");
                sc.next();
            }
        }
    }

    public static void imprimirReporte(String nombre, double parcial1, double parcial2, double parcial3, double promedio, int asistencia, boolean entregoProyecto, double calfinal, String estado) {
        System.out.println("---REPORTE FINAL---");
        System.out.println("Nombre: " + nombre);
        System.out.printf("Calificacion del parcial 1: %.2f\n", parcial1);
        System.out.printf("Calificacion del parcial 2: %.2f\n", parcial2);
        System.out.printf("Calificacion del parcial 3: %.2f\n", parcial3);
        System.out.printf("Promedio: %.2f\n", promedio);
        System.out.println("Asistencia: " + asistencia + "%");
        System.out.println("Entrego proyecto: " + entregoProyecto);
        System.out.printf("Calificacion final: %.2f\n", calfinal);
        System.out.println("Estado: " + estado);
    }
}