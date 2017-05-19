package pp2.app2.modelo.domain;

/**
 * Created by fcazzari on 19/05/2017.
 */

public class MercadoPago implements MedioDePago {

    private String numero;

    public MercadoPago(String numero) {
        this.numero = numero;
    }

    @Override
    public void pagar(double total) {

    }
}
