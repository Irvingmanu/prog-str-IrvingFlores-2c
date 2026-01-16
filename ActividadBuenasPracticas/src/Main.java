import java.util.Scanner;

public class Main {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int numIngresado = pedirEntero(sc, "Ingresa un numero: ");
        int resultado = sumarHasta(sc, numIngresado);
        System.out.print("Resultado: " + resultado);
    }

    /**
     * Metodo para obtener un numero entero desde la consola
     * @param sc -> objeto previamente instanciado
     * @param mensaje -> mensaje que se mostrara en consola
     * @return El numero entero ingresado por el usuario
     */
    public static int pedirEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    /**
     * Metodo para sumar mientras i sea menor o igual a numIngresado
     * @param numIngresado -> esta variable determina cuándo se rompe el ciclo
     * @return Int suma
     */
    public static int sumarHasta(Scanner sc, int numIngresado) {
        int suma = 0;
        for (int i = 1; i <= numIngresado; i++) {
            suma += i;
        }
        return suma;
    }
}
