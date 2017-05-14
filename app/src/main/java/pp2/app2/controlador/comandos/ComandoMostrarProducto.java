package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.Producto;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class ComandoMostrarProducto implements Command
{
    private Producto producto;

    public ComandoMostrarProducto(Producto producto)
    {
        this.producto = producto;
    }

    public Producto obtenerDetalles()
    {
        return producto;
    }

    public int execute()
    {
        //En realidad no me sirve para nada, si no tendriamos que usar objects
        //Conectarase a la api y obtener los detalles
        //Si se conecta ok agregar al producto los detalles, si no devolver el producto, en la vista se mostrará sin los detalles
        return 0;
    }
}
