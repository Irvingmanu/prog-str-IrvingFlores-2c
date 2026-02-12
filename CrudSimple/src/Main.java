import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcion;
        int id;
        String nombre;
        int idBuscada;
        Persona[] personas = new Persona[20];
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID (solo activas)");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID (solo activas)");
            System.out.println("0) Salir");
            opcion = ValidarDatos.validarInt("Ingresa tu opcion: ", sc);

            switch (opcion) {
                case 1:
                    id = ValidarDatos.validarId("Ingresa el ID: ", sc, personas);
                    sc.nextLine();
                    nombre = ValidarDatos.validarNombre("Ingresa el nombre: ", sc);
                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] == null) {
                            personas[i] = new Persona(id, nombre, true);
                            break;
                        }
                    }
                    break;
                case 2:
                    idBuscada = ValidarDatos.validarInt("Ingresa el ID a buscar: ", sc);
                    boolean encontrada = false;
                    for (Persona persona : personas) {
                        if (persona != null && persona.getId() == idBuscada && persona.isActiva()) {
                            System.out.println("------------------");
                            System.out.println("ID: " + persona.getId());
                            System.out.println("Nombre: " + persona.getNombre());
                            System.out.println("Esta activa: " + persona.isActiva());
                            System.out.println("------------------");
                            encontrada = true;
                            break;
                        }
                    }
                    if (!encontrada) {
                        System.out.println("La persona no esta activa");
                        break;
                    }
                    break;
                case 3:
                    int baja = ValidarDatos.validarInt("Ingresa el id para la baja logica: ", sc);
                    boolean esEncontrada = false;
                    for (Persona persona : personas) {
                        if (persona != null && persona.getId() == baja && persona.isActiva()) {
                            System.out.println("La persona con nombre " + persona.getNombre() + " se dio de baja");
                            persona.setActiva(false);
                            esEncontrada = true;
                        }
                    }
                    if (!esEncontrada) {
                        System.out.println("No se encontro a la persoma");
                    }
                    break;
                case 4:
                    System.out.println("Lista de activas");
                    boolean activa = false;
                    for (Persona persona : personas) {
                        if (persona != null && persona.isActiva()) {
                            System.out.println("-----------------");
                            System.out.println("ID: " + persona.getId());
                            System.out.println("Nombre: " + persona.getNombre());
                            System.out.println("Esta activa: " + persona.isActiva());
                            System.out.println("-----------------");
                            activa = true;
                        }
                    }
                    if (!activa) {
                        System.out.println("No hay personas activas");
                    }
                    break;
                case 5:
                    int renombrar = ValidarDatos.validarInt("Ingresa el ID que quieres renombrar: ", sc);
                    sc.nextLine();
                    boolean encontradaR = false;
                    for (Persona persona : personas) {
                        if (persona != null && persona.getId() == renombrar && persona.isActiva()) {
                            String nombreNuevo = ValidarDatos.validarNombre("Ingresa el nuevo nombre: ", sc);
                            persona.setNombre(nombreNuevo);
                            encontradaR = true;
                        }
                    }
                    if (!encontradaR) {
                        System.out.println("La persona esta inactiva o no existe");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Ingresa una opcion valida");
            }
        } while (opcion != 0);
    }
}