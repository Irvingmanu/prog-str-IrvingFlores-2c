import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator shippingCalculator = new ShippingCalculator();
        //I-P-O
        //Input
        double pesoKg = leerDoubleEnRango("Ingresa el peso en un rango de (0.1-50.0): ", sc, 0.1, 50.0);
        int distanciaKm = leerIntEnRango("Ingresa la distancia en un rango de (1-2000): ", sc, 1, 2000);
        int tipoServicio = leerIntEnRango("Ingresa el tipo de servicio 1)Estandar 2)Express: ", sc, 1, 2);
        boolean esZonaRemota = leerBoolean("¿Es zona remota? (Ingrese false o true): ", sc);

        //Process
        shippingCalculator.process(pesoKg, distanciaKm, tipoServicio, esZonaRemota);

        //Output
        imprimirTicket(pesoKg, distanciaKm, tipoServicio, esZonaRemota, shippingCalculator.subtotal, shippingCalculator.iva, shippingCalculator.total);
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
                    System.out.println("Ingresa un entero que este entre el rango");
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
                    System.out.println("Ingresa un entero que este entre el rango");
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
                return esBoolean;
            } else {
                System.out.println("Error, ingresa solo true o false");
                sc.next();
            }
        }
    }

    private static void imprimirTicket(double pesokg, int distanciakm, int tipoServicio, boolean esZonaRemota, double subtotal, double iva, double total) {
        System.out.println("---- TICKET ----");
        if (tipoServicio == 1) {
            System.out.println("Servicio: Estándar");
        } else {
            System.out.println("Servicio: Express");
        }
        System.out.println("Peso: " + pesokg + "Kg");
        System.out.println("Distancia: " + distanciakm + "Km");
        System.out.println("Zona remota: " + esZonaRemota);
        System.out.println("Subtotal: " + subtotal);
        System.out.printf("IVA: %.2f" , iva);
        System.out.println("\nTotal: " + total);
        System.out.println("---- TICKET ----");
    }
}