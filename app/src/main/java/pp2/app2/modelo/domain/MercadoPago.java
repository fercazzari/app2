package pp2.app2.modelo.domain;

/**
 * Created by fcazzari on 14/05/2017.
 */

public class MercadoPago implements MedioDePago {


    @Override
    public void pagar(double total) {
        System.out.println("$" + total + " con MercadoPago.");
    }
}
