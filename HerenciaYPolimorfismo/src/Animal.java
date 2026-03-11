public class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void comer(){
        System.out.println(name+ "Esta comiendo");
    }

    public void hacerSonido(){
        System.out.println(name+ "Esta haciendo un sonido x");
    }
}
