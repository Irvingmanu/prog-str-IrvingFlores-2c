import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular area de un circulo");
            System.out.println("5. Salir");
            System.out.println("Ingresa tu opcion: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Haz seleccionado la opcion calcular IMC");
                    System.out.println("Ingresa tu altura en metros: ");
                    double alturaM = sc.nextDouble();
                    System.out.println("Ingresa tu peso en KG: ");
                    double pesoKg = sc.nextDouble();
                    double imc = calcularIMC(pesoKg, alturaM);
                    System.out.printf("Tu IMC es: %.2f", imc);
                    break;
                case 2:
                    System.out.println("Haz seleccionado la opcion calcular area de un rectangulo");
                    System.out.println("Ingresa su altura: ");
                    double alturaR = sc.nextDouble();
                    System.out.println("Ingresa su base: ");
                    double baseR = sc.nextDouble();
                    double areaR = calcularARectangulo(alturaR, baseR);
                    System.out.printf("El area del rectangulo es: %.2f", areaR);
                    break;
                case 3:
                    System.out.println("Haz seleccionado la opcion para convertir °C a °F");
                    System.out.println("Ingresa los grados celcius a convertir: ");
                    double celcius = sc.nextDouble();
                    double fahrenheit = calcularGrados(celcius);
                    System.out.printf("Equivale a: %.2f° Fahrenheit", fahrenheit);
                    break;
                case 4:
                    System.out.println("Haz seleccionado la opcion para calcular el area de un circulo");
                    System.out.println("Ingresa el radio del circulo: ");
                    double radio = sc.nextDouble();
                    double areaCirculo = calcularACirculo(radio);
                    System.out.printf("El area del circulo es: %.2f", areaCirculo);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Error, seleccione una opcion valida");
            }
            System.out.println();

        } while (choice != 5);
    }

    /**
     * Metodo para calcular el imc del usuario con su altura y su peso
     * @param pesoKg -> El peso del usuario en KG
     * @param alturaM -> La altura del usuario en metros
     * @return -> El valor del imc
     */
    public static double calcularIMC(double pesoKg, double alturaM) {
        return pesoKg / (alturaM * alturaM);
    }

    /**
     * Metodo para calcular el area de un rectangulo multiplicando su base por su altura
     * @param alturaR -> La altura del rectangulo
     * @param baseR -> La base del rectangulo
     * @return -> El valor del area del rectangulo
     */
    public static double calcularARectangulo(double alturaR, double baseR){
        return baseR * alturaR;
    }

    /**
     * Metodo para convertir grados celcius a grados fahrenheit
     * @param celcius -> Grados celcius ingresados por el usuario
     * @return -> La conversion de los grados celcius a grados fahrenheit
     */
    public static double calcularGrados(double celcius){
        return (celcius * 1.8)+32;
    }

    /**
     * Metodo para calcular el area de n circulo con el radio y PI
     * @param radio -> Radio del circulo ingresado por el usuario
     * @return -> El valor del area del circulo calculada con el radio
     */
    public static double calcularACirculo(double radio){
        return Math.PI * Math.pow(radio, 2);
    }
}