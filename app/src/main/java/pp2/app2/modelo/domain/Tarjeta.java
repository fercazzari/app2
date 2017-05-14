package pp2.app2.modelo.domain;

/**
 * Created by fcazzari on 14/05/2017.
 */

public class Tarjeta implements MedioDePago {

    private int numero;
    private String fechaVencimiento;

    public Tarjeta(int numero, String fechaVencimiento) {
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public void pagar(double total) {
        System.out.println("$" + total + " con tarjeta de crédito.");
    }
}
