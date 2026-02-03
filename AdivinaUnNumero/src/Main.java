import java.util.Random;
import java.util.Scanner;
public class Main {
    static int fueraRango = 0;
    static int noNumerico=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int min=1;
        int max=100;
        int intentos=0;
        int limiteIntentos=7;
        boolean gano=false;
        int secreto= random.nextInt(100)+1;
        System.out.println("Adivina el numero(1-100) "+"tienes: "+limiteIntentos+" para lograrlo");

        while (intentos<limiteIntentos){
            int numero=obtenerNumeroValido("Intento: "+(intentos+1),sc,min,max); // vamos a crear metodo para pedir un numero valido
            intentos++;
            if (numero ==secreto){
                System.out.println("Felicidades ganaste en el intento: "+intentos);
                gano=true;
                break;
            } else if (numero>secreto) {
                System.out.println("El numero secreto es menor a "+numero);
            }else {
                System.out.println("El numero secreto es mayor a "+numero);
            }
        }
        if (!gano){//bandera para saber si gano o perdio
            System.out.println("Perdiste, el numero secreto era: "+secreto);

        }
        System.out.println("Veces que se ingreso un numero fuera del rango: "+fueraRango);
        System.out.println("Veces que se imgreso un dato no númerico: "+noNumerico);
    }

    public static int obtenerNumeroValido(String mensaje, Scanner sc, int min, int max){
        int entrada;
        while (true){
            System.out.println(mensaje);
            if (sc.hasNextInt()){ // para saber si el dato es numerico
                entrada=sc.nextInt();
                if (entrada>=min && entrada<=max){
                    return entrada;
                }
                System.out.println("El numero ingresado esta fuera de rango (1-100)");
                fueraRango +=1;
            } else{
                System.out.println("El dato ingresado no es numerico");
                noNumerico+=1;
                sc.next(); //Consumer el dato de entrada, para evitar un ciclo infinito
            }
        }
    }
}