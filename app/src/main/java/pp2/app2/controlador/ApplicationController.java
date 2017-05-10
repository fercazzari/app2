package pp2.app2.controlador;

import pp2.app2.controlador.Comandos.ComandoPedido;
import pp2.app2.controlador.Comandos.ComandoMostrarProducto;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Domicilio;
import pp2.app2.modelo.Producto;

/**
 * Created by fcazzari on 05/05/2017.
 */

public class ApplicationController {

    private ComandoPedido pedido;
    private ComandoMostrarProducto mostrarProducto;

    public void accionBtnComprar(Producto producto)
    {
        //Analizar de que de que vista viene si es necesario
        //Llamar al comando que corresponde
        Carrito carritoDeCompras = new Carrito();
        carritoDeCompras.agregarItem(producto);
        pedido = new ComandoPedido(carritoDeCompras);
        int resultadoPedido= pedido.realizarPedido();
        //Matar vista o no
        switch (resultadoPedido)
        {
            case 0:
                mostrarVistaPedidoOk();
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
        //Llamar a la vista correspondiente
        if(false)//tengoElDomicilio)
        {
            //Mostrar vista con domicilio/s Registrados
            //Le pregunto si quiere que se entregue en ese domicilio
        }
        else
        {
            //Mostrar vista para ingresar domicilio
            //Le pido que ingrese los datos del domicilio
        }
    }

    public void accionEntregarEnOtroDomicilio()
    {
        //Mostrar vista para ingresar domicilio
    }

    public void aceptarDomicilioDeEntrega(Domicilio domicilioDeEntrega)
    {
        //Falta mucho codigo

        if(false)//tengoLosDatosDeLaTarjeta)
        {
            //Mostrar vista con tarjeta/s registradas
            //Le pregunto si quiere pagar con esa tarjeta
        }
        else
        {
            //Mostrar vista para ingresar medio de pago
            //Le pido que ingrese los datos de la tarjeta
        }
    }

    public void accionVerificarTarjeta()
    {

    }

    public void confirmarCompra()
    {

    }

    public void accionBtnDetalles(Producto producto)
    {
        //Analizar de que vista viene si es necesario
        mostrarProducto = new ComandoMostrarProducto(producto);
        Producto productoConDetalles = mostrarProducto.obtenerDetalles();
        //Llamar a la vista correspondiente vista(productoConDetalles)
    }

    private void mostrarVistaPedidoOk()
    {

    }

    private void informarSinStock()
    {
        //cartelito(Constantes.msg_sin_stock);
    }
}
