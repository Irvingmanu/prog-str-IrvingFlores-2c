import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Alumno[] alumnos = new Alumno[25];
        Scanner sc = new Scanner(System.in);
        int opcion;
        int id;
        String nombre;
        int idBuscada;
        double promedio;
        boolean hayActivos;

        do {
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja lógica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            opcion = ValidarDatos.validarInt("Ingresa tu opcion: ", sc);


            switch (opcion) {
                case 1:
                    System.out.println("--Alta alumno--");
                    id = ValidarDatos.validarId("Ingresa el id: ", sc, alumnos);
                    sc.nextLine();
                    nombre = ValidarDatos.validarNombre("Ingresa el nombre: ", sc);
                    promedio = ValidarDatos.validarPromedio("Ingresa el promedio: ", sc, 0, 10);
                    boolean hayEspacio = false;
                    for (int i = 0; i < alumnos.length; i++) {
                        if (alumnos[i] == null) {
                            alumnos[i] = new Alumno(id, nombre, promedio, true);
                            System.out.println("El alumno " + alumnos[i].getNombre() + " se dio de alta correctamente");
                            hayEspacio = true;
                            break;
                        }
                    }
                    if (!hayEspacio) {
                        System.out.println("Ya no hay cupos para dar de alta");
                    }
                    break;
                case 2:
                    System.out.println("--Buscar por ID (solo activos)--");
                    idBuscada = ValidarDatos.validarInt("Ingresa el ID para buscar: ", sc);
                    boolean encontrado = false;
                    for (Alumno alumno : alumnos) {
                        if (alumno != null && alumno.getId() == idBuscada && alumno.isActivo()) {
                            System.out.println("------------------");
                            System.out.println("ID: " + alumno.getId());
                            System.out.println("Nombre: " + alumno.getNombre());
                            System.out.println("Promedio: " + alumno.getPromedio());
                            System.out.println("Esta activa: " + alumno.isActivo());
                            System.out.println("------------------");
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("El alumno no esta activo o no existe");
                    }
                    break;
                case 3:
                    System.out.println("--Actualizar promedio por ID (solo activos)--");
                    idBuscada = ValidarDatos.validarInt("Ingresa el ID del alumno para actualizar su promedio: ", sc);
                    boolean encontradoPromedio = false;
                    for (Alumno alumno : alumnos) {
                        if (alumno != null && alumno.getId() == idBuscada && alumno.isActivo()) {
                            double nuevoPromedio = ValidarDatos.validarPromedio("Ingresa el promedio nuevo: ", sc, 0, 10);
                            alumno.setPromedio(nuevoPromedio);
                            System.out.println("Se cambio el promedio del alumno " + alumno.getNombre() + " correctamente");
                            encontradoPromedio = true;
                        }
                    }
                    if (!encontradoPromedio) {
                        System.out.println("El alumno no esta activo o no existe");
                    }
                    break;
                case 4:
                    System.out.println("--Baja lógica por ID--");
                    idBuscada = ValidarDatos.validarInt("Ingresa el ID para hacer baja logica: ", sc);
                    boolean esEncontrada = false;
                    for (Alumno alumno : alumnos) {
                        if (alumno != null && alumno.getId() == idBuscada && alumno.isActivo()) {
                            alumno.setActivo(false);
                            System.out.println("Se dio de baja al alumno " + alumno.getNombre() + " correctamente");
                            esEncontrada = true;
                        }
                    }
                    if (!esEncontrada) {
                        System.out.println("El alumno esta no esta activo o no existe");
                    }
                    break;
                case 5:
                    System.out.println("--Listar activos--");
                    hayActivos = false;
                    for (Alumno alumno : alumnos) {
                        if (alumno != null && alumno.isActivo()) {
                            System.out.println("-----------------");
                            System.out.println("ID: " + alumno.getId());
                            System.out.println("Nombre: " + alumno.getNombre());
                            System.out.println("Promedio: " + alumno.getPromedio());
                            System.out.println("Esta activa: " + alumno.isActivo());
                            System.out.println("-----------------");
                            hayActivos = true;
                        }
                    }
                    if (!hayActivos) {
                        System.out.println("No hay alumnos activos");
                    }
                    break;
                case 6:
                    System.out.println("--Reportes--");
                    int opcion2;
                    do {
                        System.out.println("1) Mostrar promedio general de alumnos ACTIVOS");
                        System.out.println("2) Mostrar alumno activo con mayor promedio");
                        System.out.println("3) Mostrar alumno activo con menor promedio");
                        System.out.println("4) Mostrar cuántos alumnos activos tienen promedio >= 8.0");
                        System.out.println("0) Regresar al menu principal");
                        opcion2 = ValidarDatos.validarInt("Ingresa tu opcion: ", sc);

                        switch (opcion2) {
                            case 1:
                                System.out.println("--Mostrar promedio general de alumnos ACTIVOS--");
                                boolean hayAlumnos = false;
                                double promGeneral = 0;
                                double promGenContador = 0;
                                for (Alumno alumno : alumnos) {
                                    if (alumno != null && alumno.isActivo()) {
                                        promGeneral += alumno.getPromedio();
                                        promGenContador += 1;
                                        hayAlumnos = true;
                                    }
                                }
                                if (!hayAlumnos) {
                                    System.out.println("No hay alumnos activos");
                                } else {
                                    promGeneral = CalculadoraAlumno.calcularPromGeneral(promGeneral, promGenContador);
                                    System.out.printf("El promedio general de los alumnos activos es: %.2f\n", promGeneral);
                                }
                                break;
                            case 2:
                                System.out.println("--Mostrar alumno activo con mayor promedio--");
                                Alumno mayPromedio = null;
                                double mayPromTemporal = -67;
                                for (Alumno alumno : alumnos) {
                                    if (alumno != null && alumno.isActivo()) {
                                        if (alumno.getPromedio() > mayPromTemporal) {
                                            mayPromTemporal = alumno.getPromedio();
                                            mayPromedio = alumno;
                                        }
                                    }
                                }
                                if (mayPromedio == null) {
                                    System.out.println("No hay alumnos activos");
                                } else {
                                    System.out.println("El alumno " + mayPromedio.getNombre() +
                                            " tiene el mayor promedio con: " + mayPromedio.getPromedio());
                                }
                                break;
                            case 3:
                                System.out.println("--Mostrar alumno activo con menor promedio--");
                                Alumno menPromedio = null;
                                double menPromTemporal = 11;
                                for (Alumno alumno : alumnos) {
                                    if (alumno != null && alumno.isActivo()) {
                                        if (alumno.getPromedio() < menPromTemporal) {
                                            menPromTemporal = alumno.getPromedio();
                                            menPromedio = alumno;
                                        }
                                    }
                                }
                                if (menPromedio == null) {
                                    System.out.println("No hay alumnos activos");
                                } else {
                                    System.out.println("El alumno " + menPromedio.getNombre() +
                                            " tiene el menor promedio con: " + menPromedio.getPromedio());
                                }
                                break;
                            case 4:
                                System.out.println("--Mostrar cuántos alumnos activos tienen promedio >= 8.0--");
                                boolean hayAlumnosProm = false;
                                int contAlumnos = 0;
                                for (Alumno alumno : alumnos) {
                                    if (alumno != null && alumno.isActivo()) {
                                        if (alumno.getPromedio() >= 8) {
                                            contAlumnos += 1;
                                            hayAlumnosProm = true;
                                        }
                                    }
                                }
                                if (hayAlumnosProm) {
                                    System.out.println("La cantidad de alumnos que tienen un promedio igual o mayor a 8 son: " + contAlumnos);
                                } else {
                                    System.out.println("No hay alumnos con promedio igual o mayor a 8");
                                }
                                break;
                            case 0:
                                System.out.println("Regresando...");
                                break;
                            default:
                                System.out.println("Ingresa una opcion valida");
                        }
                    } while (opcion2 != 0);
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