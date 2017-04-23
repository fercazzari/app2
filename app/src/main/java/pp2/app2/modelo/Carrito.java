package pp2.app2.modelo;

import java.util.LinkedList;
import java.util.List;

import pp2.app2.helpers.CarritoUOW;

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
        return this.getUOW().hayCambios();
    }

    public void sincronizado()
    {
        this.carritoUOW.clear();
    }
}
