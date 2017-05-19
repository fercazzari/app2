package pp2.app2.modelo.domain;

/**
 * Created by fcazzari on 19/05/2017.
 */

public class Tarjeta implements MedioDePago {

    private String numero;

    public Tarjeta (String numero) {
        this.numero = numero;
    }

    @Override
    public void pagar(double total) {

    }
}
