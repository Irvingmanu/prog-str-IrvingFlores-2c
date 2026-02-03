import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double centigrados;
        double fahrenheit;
        double kilometros;
        double millas;
        int totalConversiones = 0;
        int CaF = 0;
        int FaC = 0;
        int kmAMillas = 0;
        int millasAKm = 0;

        do {
            System.out.println("Menu:");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            opcion = validarOpcion("Ingresa tu opcion: ", sc);

            switch (opcion) {
                case 1:
                    System.out.println("1) °C a °F");
                    centigrados = validarDatos("Ingresa los grados centigrados: ", sc);
                    fahrenheit = (centigrados * 1.8) + 32;
                    CaF += 1;
                    totalConversiones += 1;
                    System.out.printf("La conversion a fahrenheit es: %.2f °F\n", fahrenheit);
                    break;
                case 2:
                    System.out.println("2) °F a °C");
                    fahrenheit = validarDatos("Ingrese los grados fahrenheit: ", sc);
                    centigrados = (fahrenheit - 32) / 1.8;
                    FaC += 1;
                    totalConversiones += 1;
                    System.out.printf("La conversion a centigrados es: %.2f °C\n", centigrados);
                    break;
                case 3:
                    System.out.println("3) Km a Millas");
                    kilometros = validarDatos("Ingresa los kilometros: ", sc);
                    millas = kilometros / 1.609;
                    kmAMillas += 1;
                    totalConversiones += 1;
                    System.out.printf("Esto equivale a %.2f millas\n", millas);
                    break;
                case 4:
                    System.out.println("4) Millas a Km");
                    millas = validarDatos("Ingresa las millas: ", sc);
                    kilometros = millas * 1.609;
                    millasAKm += 1;
                    totalConversiones += 1;
                    System.out.printf("Esto equivale a %.2f kilometros\n", kilometros);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Error, opcion invalida");
            }
        } while (opcion != 5);
        System.out.println("Conversiones totales: " + totalConversiones);
        System.out.println("Conversiones del tipo °C a °F: " + CaF);
        System.out.println("Conversiones del tipo °F a °C: " + FaC);
        System.out.println("Conversiones del tipo Km a Millas: " + kmAMillas);
        System.out.println("Conversiones del tipo Millas a Km: " + millasAKm);
    }

    /**
     * Metodo para validar que el dato ingresado sea un dato numerico
     * @param mensaje -> El mensaje que se mostrara en consola
     * @param sc -> Objeto previamente instanciado
     * @return -> La entrada que se recibe del usuario si es correcta
     */
    public static double validarDatos(String mensaje, Scanner sc) {
        double entrada;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) { // Para saber si el dato es numerico
                entrada = sc.nextDouble();
                return entrada;
            } else {
                System.out.println("Error, el dato ingresado no es numerico, prueba otra vez");
                sc.next(); //Consume el dato de entradaCentigrados, para evitar un ciclo infinito
            }
        }
    }

    /**
     * Metodo para validar que la veriable opcion sea numerica
     * @param mensaje -> El mensaje que se mostrara en consola
     * @param sc -> Objeto previamente instanciado
     * @return -> La entrada que se recibe del usuario si es correcta
     */
    public static int validarOpcion(String mensaje, Scanner sc) {
        int opcionEntrada;
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                opcionEntrada = sc.nextInt();
                return opcionEntrada;
            } else {
                System.out.println("El dato ingresado no es numerico entero, prueba otra vez");
                sc.next();
            }
        }
    }
}




