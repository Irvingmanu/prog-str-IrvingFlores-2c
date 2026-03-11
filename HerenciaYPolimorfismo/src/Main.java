//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Perro toby = new Perro("Toby");
        Gato pepo = new Gato("Pepo");

        toby.comer();
        pepo.comer();

        toby.hacerSonido();
        pepo.hacerSonido();
    }
}