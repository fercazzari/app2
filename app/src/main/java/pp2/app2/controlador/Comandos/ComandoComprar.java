package pp2.app2.controlador.Comandos;

import pp2.app2.modelo.Carrito;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class ComandoComprar
{
    private Carrito carrito;
    //El resto de los atributos pueden se cosas que pueden pasar cuando compras

    public ComandoComprar(Carrito carrito)
    {
        this.carrito = carrito;
    }

    //Podria ser un int y manejar errores, obviamente como recomienda gateway, desde el cliente
    public int realizarCompra()
    {
        //Conectarse al servidor y realizar el pedido
        return 0;
    }
}
