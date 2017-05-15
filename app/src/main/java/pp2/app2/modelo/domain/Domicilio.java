package pp2.app2.modelo.domain;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class Domicilio {

    private String datos;

    public Domicilio () {
        this.datos = "";
    }

    public Domicilio(String datos) {
        this.datos = datos;
    }

    public String getDatos () {
        return this.datos;
    }
}
