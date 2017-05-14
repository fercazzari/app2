package pp2.app2.modelo.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by fcazzari on 08/04/2017.
 */

public class Carrito {

    private List<Producto> productos;
    CarritoUOW carritoUOW;

    public Carrito() {
        this.productos = new LinkedList<Producto>();
        this.carritoUOW = new CarritoUOW();
    }

    public boolean agregarItem(Producto producto) {
        carritoUOW.registrarNew(producto);
        return this.productos.add(producto);
    }

    public boolean eliminarItem(Producto producto) {
        carritoUOW.registrarRemoved(producto);
        return this.productos.remove(producto);
    }

    public int getCantidad () {
        return this.productos.size();
    }

    public List<Producto> getItems () {
        return this.productos;
    }

    public CarritoUOW getUOW () {
        return this.carritoUOW;
    }

    public boolean hayQueSincronizar()
    {
        return !this.getUOW().isEmpty();
    }

    public void sincronizado()
    {
        this.carritoUOW.clear();
    }

    public void vaciar()
    {
        for (Producto p : productos)
        {
            this.carritoUOW.registrarRemoved(p);
        }
        this.productos.clear();
    }

    public double getTotal() {
        double total = 0;
        for (Producto p : this.productos) {
            total += p.getPrecio();
        }
        return total;
    }
}
