package pp2.app2.controlador.Comandos;

import pp2.app2.modelo.Producto;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class ComandoMostrarProducto
{
    private Producto producto;

    public ComandoMostrarProducto(Producto producto)
    {
        this.producto = producto;
    }

    public Producto obtenerDetalles()
    {
        //Conectarase a la api y obtener los detalles
        //Si se conecta ok agregar al producto los detalles, si no devolver el producto, en la vista se mostrará sin los detalles
        return producto;
    }
}
