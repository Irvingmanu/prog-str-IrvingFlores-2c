public class Ticket {

    public   final double DESCUENTO=0.10;
    public final double PRECIO=10;
    public double subtotal;
    public double descuentoCalculado;
    public double total;

    public void process(int cantidad){
        calcularSubtotal(cantidad);
        calcularDescuento(this.subtotal);
        calcularTotal(this.subtotal);
    }
    private void calcularSubtotal(int cantidad){
        this.subtotal= cantidad*PRECIO;
    }

    private void calcularDescuento(double subtotal){
        this.descuentoCalculado= subtotal*DESCUENTO;
    }

    private void calcularTotal(double subtotal){
        this.total= subtotal-this.descuentoCalculado;
    }

    public void imprimirTicket(double cantidad){
        System.out.println("--Ticket--");
        System.out.println("La cantidad de articulos fue: "+cantidad);
        System.out.println("El subtotal fue: "+this.subtotal);
        System.out.println("El descuento calculado fue de: "+this.descuentoCalculado);
        System.out.println("El total del ticket fue: "+this.total);
        System.out.println("--Ticket--");
    }
}
