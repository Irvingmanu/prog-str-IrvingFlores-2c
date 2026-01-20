import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = pedirEntero(scanner,"Ingresa el valor de a: ");
        int b = pedirEntero(scanner,"Ingresa el valor de b: ");
        int c = pedirEntero(scanner,"Ingresa el valor de c: ");
        int suma = hacerSuma(a, b, c);
        System.out.println("suma = " + suma);
        System.out.println("promedio = " + (suma / 3.0));
    }

    /**
     * Metodo para pedir un entero
     * @param scanner -> Previamente configurado para leer
     * @param mensaje -> El mensaje que se imprimira en consola
     * @return -> El valor entero ingresado por el usuario
     */
    public static int pedirEntero(Scanner scanner, String mensaje){
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    /**
     * Metodo para calcular la suma
     * @param a -> Valor entero ingresado por el usuario
     * @param b -> Valor entero ingresado por el usuario
     * @param c -> Valor entero ingresado por el usuario
     * @return -> El valor de suma
     */
    public static int hacerSuma(int a, int b, int c) {
        int suma = a + b + c;
        return suma;
    }
}