public class Gato extends Animal{

    public Gato(String name) {
        super(name); //Inicializa la clase padre, es animal
    }

    @Override
    public void hacerSonido(){
        System.out.println(name+" Hacer miau");
    }
}
