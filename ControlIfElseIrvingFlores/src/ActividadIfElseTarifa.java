import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edad;
        int tarifa = 0;
        boolean eresEstudiante;
        String estudianteOpcion;

        edad = pedirEdad(sc, "Ingresa tu edad: ");
        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
        } else {
            estudianteOpcion = validarSiEsEstudiante(sc, "¿Eres estudiante? (si/no): ");
            if (estudianteOpcion.equals("si")) {
                eresEstudiante = true;
            } else {
                eresEstudiante = false;
            }
            if (edad < 12) {
                tarifa = 50;
            } else if (edad <= 17 && eresEstudiante) {
                tarifa = 60;
            } else if (edad <= 17) {
                tarifa = 80;
            } else if (eresEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
            System.out.println("Tu edad es: " + edad);
            if (eresEstudiante) {
                System.out.println("Eres estudiante");
            } else {
                System.out.println("No eres estudiante");
            }
            System.out.println("Tu tarifa es: " + tarifa);
        }
    }
    /**
     * Metodo para pedir un numero entero (la edad)
     * @param sc -> Objeto previamente instanciado
     * @param mensaje ->  El mensaje que se imprimira en consola
     * @return -> Dato entero ingresado por el usuario
     */
    public static int pedirEdad(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    /**
     * Metodo para preguntar al usuario si es estudiante
     * @param sc -> Objeto previamente instanciado
     * @param mensaje -> El mensaje que se imprimira en consola
     * @return -> Dato string ingresado por el usuario
     */
    public static String validarSiEsEstudiante(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.next();
    }
}