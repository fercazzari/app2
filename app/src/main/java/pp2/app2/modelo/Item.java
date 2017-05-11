package pp2.app2.modelo;

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

    public boolean esProducto(Producto p) {
        return false;
    }

    public void agregarUnidad() {
    }
}
