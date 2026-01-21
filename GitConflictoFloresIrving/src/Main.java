import java.util.Scanner;

public class Main {
    public static double IVA = 0.16;
    public static double DESCUENTO = 0.10;
    public static double UMBRAL_DESCUENTO = 1000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = pedirDouble(scanner, "Subtotal: ");
        double total = calcularTotalConIva(subtotal);
        total = aplicarDescuentoSiAplica(total, subtotal);

        System.out.printf("Total a pagar: %.2f%n", total);
    }

    /**
     * Metodo para pedir un double
     * @param scanner -> Previamente configurado para leer lo que ingrese el usuario
     * @param mensaje -> El mensaje que se imprimira en consola
     * @return -> Lo que ingrese el usuario
     */
    public static double pedirDouble(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }

    /**
     * Metodo para agregar el IVA al subtotal
     * @param subtotal -> Valor double ingresado por el usuario
     * @return -> El subtotal con IVA
     */
    public static double calcularTotalConIva(double subtotal){
        return subtotal + (subtotal * IVA);
    }

    /**
     * Metodo para la decision de si se aplica el descuento o no
     * @param total -> Variable para guardar el valor final
     * @param subtotal -> Variable para guardar el valor ingresado por el usuario
     * @return -> El valor final
     */
    public static double aplicarDescuentoSiAplica(double total, double subtotal){
        if (subtotal > UMBRAL_DESCUENTO) {
            total = total - (total * DESCUENTO);
        }
        return total;
    }
}