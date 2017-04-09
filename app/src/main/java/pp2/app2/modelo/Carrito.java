package pp2.app2.modelo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fcazzari on 08/04/2017.
 */

public class Carrito {

    private List<Producto> productos;

    Carrito() {
        this.productos = new LinkedList<Producto>();
    }

    public boolean agregarItem(Producto producto) {
        return this.productos.add(producto);
    }

    public int getCantidad () {
        return this.productos.size();
    }

    public double getTotal() {
        return 0;
    }

}
