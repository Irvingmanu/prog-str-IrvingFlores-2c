import java.util.Scanner;

public class ValidarDatos {

    public static int validarInt(String msg, Scanner sc) {
        int entero;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                entero = sc.nextInt();
                return entero;
            } else {
                System.out.println("Ingresa un valor numerico");
                sc.next();
            }
        }
    }

    public static int validarId(String msg, Scanner sc, Persona[] listaPersonas) {
        int id;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                id = sc.nextInt();
                if (id <= 0) {
                    System.out.println("Ingresa un ID mayor a 0");
                } else {
                    boolean esRepetido = false;

                    for (Persona listaPersona : listaPersonas) {
                        if (listaPersona != null && listaPersona.getId() == id) {
                            esRepetido = true;
                            break;
                        }
                    }
                    if (esRepetido) {
                        System.out.println("Ese ID ya existe intenta de nuevo");
                    } else {
                        return id;
                    }
                }
            } else {
                System.out.println("Ingresa un valor numerico");
                sc.next();
            }
        }
    }

    public static String validarNombre(String msg, Scanner sc) {
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
}
