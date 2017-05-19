package pp2.app2.modelo.domain;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class Item
{
    private Producto producto;
    private int cantidad;

    public Item (Producto producto, int cantidad)
    {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto () {
        return this.producto;
    }

    public int getCantidad () {
        return this.cantidad;
    }

    public void agregarUnidad(Item i) {
        i.cantidad++;
    }
}
