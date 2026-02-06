public class ShippingCalculator {
    public ShippingCalculator() {

    }

    public double subtotal;
    public double iva;
    public double total;
    private static final int ESTANDAR = 50;
    private static final int EXPRESS = 90;
    private static final double COSTOPORPESO = 12.0;
    public static final double IVA = 0.16;
    private static final double comisionZonaRemota = 0.10;

    public void process(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        calcularSubtotal(pesoKg, distanciaKm, tipoServicio, zonaRemota);
        calcularIVA(this.subtotal);
        calcularTotal(this.subtotal, this.iva);
    }

    public void calcularSubtotal(double pesoKg, int distanciaKm, int tipoServicio, boolean zonaRemota) {
        this.subtotal = 0;
        if (tipoServicio == 1) {
            this.subtotal += ESTANDAR;
        } else {
            this.subtotal += EXPRESS;
        }
        this.subtotal += calcularCostoPorPeso(pesoKg, COSTOPORPESO);
        this.subtotal += calcularCostoDistancia(distanciaKm);
        if (zonaRemota) {
            this.subtotal += this.subtotal * comisionZonaRemota;
        }
    }

    private void calcularIVA(double subtotal) {
        this.iva = subtotal * IVA;
    }

    private void calcularTotal(double subtotal, double iva) {
        this.total = subtotal + iva;
    }

    public static double calcularCostoPorPeso(double pesoKg, double COSTOPORPESO) {
        return COSTOPORPESO * pesoKg;
    }

    public static double calcularCostoDistancia(double distanciaKm) {
        double costoDistancia;
        if (distanciaKm <= 50) {
            costoDistancia = 20;
        } else if (distanciaKm >= 51 && distanciaKm <= 200) {
            costoDistancia = 60;
        } else {
            costoDistancia = 120;
        }
        return costoDistancia;
    }

}
