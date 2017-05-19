package pp2.app2.modelo.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fcazzari on 19/05/2017.
 */

public class Recomendador {

    Map<Producto, Producto> sugerencias;

    public Recomendador () {
        this.sugerencias = new HashMap<Producto, Producto>();
    }

    public Producto recomendar (Producto producto) {

        Producto resultado = new Producto();

        for (Map.Entry<Producto, Producto> s : sugerencias.entrySet()) {
            Producto key = s.getKey();
            Producto value = s.getValue();

            if (key.equals(producto))
                resultado = value;
        }

        return resultado;
    }

}
