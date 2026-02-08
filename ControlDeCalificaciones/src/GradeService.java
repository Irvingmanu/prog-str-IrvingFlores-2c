public class GradeService {
    public GradeService() {

    }

    private static final double PORCENTAJE_PROMEDIO = 0.7;
    private static final double PORCENTAJE_ASISTENCIA = 0.3;

    public static double calcularPromedio(double a, double b, double c) {
        return (a + b + c) / 3;
    }

    public static double calcularFinal(double promedio, int asistencia) {
        return (promedio * PORCENTAJE_PROMEDIO) + (asistencia * PORCENTAJE_ASISTENCIA);
    }

    public static String determinarEstado(int asistencia, boolean entregoProyecto, double calificacionFinal) {
        String estado;
        if (asistencia < 80) {
            estado = "REPROBADO por asistencia";
        } else if (!entregoProyecto) {
            estado = "REPROBADO por proyecto";
        } else if (calificacionFinal >= 70) {
            estado = "APROBADO";
        } else {
            estado = "REPROBADO por calificacion";
        }
        return estado;
    }

}