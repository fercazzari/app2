package pp2.app2.controlador;

import android.widget.Switch;

import pp2.app2.controlador.Comandos.ComandoComprar;
import pp2.app2.controlador.Comandos.ComandoMostrarProducto;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Producto;

/**
 * Created by fcazzari on 05/05/2017.
 */

public class ApplicationController {

    private ComandoComprar comprar;
    private ComandoMostrarProducto mostrarProducto;

    public void accionBtnComprar(Producto producto)
    {
        //Analizar de que de que vista viene
        //Llamar al comando que corresponde
        Carrito carritoDeCompras = new Carrito();
        carritoDeCompras.agregarItem(producto);
        comprar = new ComandoComprar(carritoDeCompras);
        int resultadoCompra= comprar.realizarCompra();
        //Matar vista o no
        switch (resultadoCompra)
        {
            case 0:
                mostrarVistaCompraOk();
                break;
            case 1:
                informarSinStock();
                break;
            case 2:
                MensajesComunes.informarErrorDeConexion();
                break;
            default:
                MensajesComunes.informarErrorGeneral();
                break;
        }
    }

    public void accionBtnDetalles(Producto producto)
    {
        //Analizar de que vista viene

    }

    private void mostrarVistaCompraOk()
    {

    }

    private void informarSinStock()
    {
        //cartelito(Constantes.msg_sin_stock);
    }
}
