import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        InputValidator inputValidator = new InputValidator();
        Scanner sc = new Scanner(System.in);
        //I-P-O
        //Input
        int cantidad = inputValidator.getValidInt("Ingresa la cantidad de articulos: ", sc);
        //Process
        ticket.process(cantidad);
        //Output
        ticket.imprimirTicket(cantidad);
    }
}