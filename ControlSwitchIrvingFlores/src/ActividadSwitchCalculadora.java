import java.util.Scanner;

public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        double numeroA;
        double numeroB;
        double resultado;
        System.out.println("Menu:");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
        System.out.println("Ingresa tu opcion: ");
        opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                numeroA = pedirDouble(sc, "Ingresa el numero 1: ");
                numeroB = pedirDouble(sc, "Ingresa el numero 2: ");
                resultado = hacerSuma(numeroA, numeroB);
                System.out.print("La suma de los numeros es: " + resultado);
                break;
            case 2:
                numeroA = pedirDouble(sc, "Ingresa el numero 1: ");
                numeroB = pedirDouble(sc, "Ingresa el numero 2: ");
                resultado = hacerResta(numeroA, numeroB);
                System.out.print("La resta de los numeros es: " + resultado);
                break;
            case 3:
                numeroA = pedirDouble(sc, "Ingresa el numero 1: ");
                numeroB = pedirDouble(sc, "Ingresa el numero 2: ");
                resultado = hacerMultiplicacion(numeroA, numeroB);
                System.out.print("La multiplicacion de los numeros es: " + resultado);
                break;
            case 4:
                numeroA = pedirDouble(sc, "Ingresa el numero 1: ");
                numeroB = pedirDouble(sc, "Ingresa el numero 1: ");
                if (numeroB == 0) {
                    System.out.println("No se puede dividir entre 0");
                } else {
                    resultado = hacerDivision(numeroA, numeroB);
                    System.out.print("La division de los numeros es: " + resultado);
                }
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    /**
     *Metodo para pedir un numero double al usuario
     * @param sc -> Objeto previamente instanciado
     * @param mensaje -> El mensaje que se imprimira en consola
     * @return -> El double que ingrese el usuario
     */
    public static double pedirDouble(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextDouble();
    }

    /**
     * Metodo para calcular una suma
     * @param numeroA -> El primer numero ingresado por el usuario
     * @param numeroB -> El segundo numero ingresado por el usuario
     * @return -> La suma de los dos numeros ingresados
     */
    public static double hacerSuma(double numeroA, double numeroB) {
        return numeroA + numeroB;
    }

    /**
     * Metodo para calcular una resta
     * @param numeroA -> El primer numero ingresado por el usuario
     * @param numeroB -> El segundo numero ingresado por el usuario
     * @return -> La resta de los dos numeros ingresados
     */
    public static double hacerResta(double numeroA, double numeroB) {
        return numeroA - numeroB;
    }

    /**
     * Metodo para calcular la multiplicacion
     * @param numeroA -> El primer numero ingresado por el usuario
     * @param numeroB -> El segundo numero ingresado por el usuario
     * @return -> La multipicacion de los dos numeros ingresados
     */
    public static double hacerMultiplicacion(double numeroA, double numeroB) {
        return numeroA * numeroB;
    }

    /**
     * Metodo para calcular una division
     * @param numeroA -> El primer numero ingresado por el usuario
     * @param numeroB -> El segundo numero ingresado por el usuario
     * @return -> La divison de los dos numeros ingresados
     */
    public static double hacerDivision(double numeroA, double numeroB) {
        return numeroA / numeroB;
    }
}




