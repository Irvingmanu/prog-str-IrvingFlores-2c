import java.util.Scanner;
public class MainB {
    public static double BAJO = 18.5;
    public static double MEDIO=25;
    public static double ALTO=30;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double pesoKG=obtenerDouble(sc, "Ingresa el pero en (KG) -> 80");
        double alturaM=obtenerDouble(sc, "Ingresa la Altura en (M) -> 1.80");
        double IMC= calcularIMC(pesoKG,alturaM);
        System.out.println("El IMC es: "+IMC);
        String clasificacionIMC= clasificarIMC(IMC);
        System.out.println("Clasificación:" +clasificacionIMC);
    }

    /**
     * Metodo para obtener un numero double desde la consola
     * @param sc -> objeto previamente instanciado
     * @param mensaje -> mensaje a mosntrar en consola
     * @return
     */ public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /**
     * Metodo para calcular y devolver el IMC con con formula peso/altura al cuadrado
     * @param pesoKg -> expresado en KG (80)
     * @param alturaM -> expresado en M (1.80)
     * @return -> double IMC
     */
    public static double calcularIMC(double pesoKg, double alturaM){
        return pesoKg/(alturaM*alturaM);
    }

    /**
     *Metodo que devuelve la clasificación basada en el IMC
     * @param IMC -> previamente calculado
     * @return String clasificacion
     */
    public static String clasificarIMC(double IMC){
        if(IMC<BAJO) return "Peso Bajo";
        else if(IMC<MEDIO) return "Medio";
        else if(IMC<ALTO) return "Sobre peso";
        else return "Obesidad";
    }
}