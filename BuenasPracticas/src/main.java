import java.util.Scanner;

public class main {
    public static double IVA = 0.16;
    public static double UMBRAL_DESCUENTO = 1000;
    public static double DESCUENTO = 0.10;

    public static void main(String[] args) {
//TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
// to see how IntelliJ IDEA suggests fixing it.
        Scanner sc = new Scanner(System.in);
        double subtotal = obtenerDouble(sc, "Dame el subtotal de la compra");
        double total = calcularTotal(subtotal);
        System.out.println("Total: " + total);
    }

    public static double obtenerDouble(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calcularTotal(double subtotal) {
        double total = subtotal + (subtotal * IVA);
        return calcularDescuento(total);
    }

    public static double calcularDescuento(double totalConIva) {
        if (totalConIva > UMBRAL_DESCUENTO) {
            totalConIva = totalConIva - (totalConIva * DESCUENTO);
        }
        return totalConIva;
    }


}