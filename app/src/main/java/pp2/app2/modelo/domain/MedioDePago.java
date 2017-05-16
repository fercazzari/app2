package pp2.app2.modelo.domain;

/**
 * Created by fcazzari on 14/05/2017.
 */

public class  MedioDePago {

    private String tipo;

    public MedioDePago(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo () {
        return this.tipo;
    }

    @Override
    public String toString() {
        return this.tipo;
    }
}
