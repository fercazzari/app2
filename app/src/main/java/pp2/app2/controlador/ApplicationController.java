package pp2.app2.controlador;

import pp2.app2.controlador.Comandos.ComandoPedido;
import pp2.app2.controlador.Comandos.ComandoMostrarProducto;
import pp2.app2.controlador.Comandos.ComandoProcesarSolicitud;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Domicilio;
import pp2.app2.modelo.Producto;
import pp2.app2.modelo.SolicitudDeCompra;

/**
 * Created by fcazzari on 05/05/2017.
 */

public class ApplicationController {

    private ComandoPedido pedido;
    private ComandoMostrarProducto mostrarProducto;
    private ComandoProcesarSolicitud procesarSolicitud;

    public void accionBtnPrepararPedido(Producto producto)
    {
        //Analizar de que de que vista viene si es necesario
        //Llamar al comando que corresponde
        Carrito carritoDeCompras = new Carrito();//Es un carrito, pero igual por ahora funciona solo para un producto
        carritoDeCompras.agregarItem(producto);
        pedido = new ComandoPedido(carritoDeCompras);
        int resultadoPedido= pedido.execute();
        //Matar vista o no
        switch (resultadoPedido)
        {
            case 0:
                //Esto es el caso básico para comprar, después vuela y vamos con lo que sigue que es agregar un domicilio de entrega
                //Instanciar la solicitud (siempre va a estar en memoria)
                //Agregarle el producto
                //Llamar a la vista correspondiente
                procesarSolicitud();       //Esta es la accion final
/*                if(false)//tengoElDomicilio)
                {
                    //Mostrar vista con domicilio/s Registrados
                    mostrarVistaDomicilios();
                }
                else
                {
                    //Mostrar vista para ingresar domicilio
                    mostrarVistaNuevoDomicilio();
                }
  */
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

    public void accionEntregarEnOtroDomicilio()
    {
        //Mostrar vista para ingresar domicilio
        mostrarVistaNuevoDomicilio();
    }

    public void accionAceptarDomicilioDeEntrega(Domicilio domicilioDeEntrega)
    {
        //Falta mucho codigo
        //Instanciar solicitud
        //Agregarle el domicilio
        mostrarVistaMediosDePago();
    }

    public void accionAceptarPagoEnEfectivo()
    {

    }

    public void accionPagoConTarjeta()
    {
        if(false)//tengoLosDatosDeLaTarjeta)
        {
            //Mostrar vista con tarjeta/s registradas
            mostrarVistaTarjetas();
        }
        else
        {
            //Mostrar vista para ingresar medio de pago
            mostrarVistaNuevaTarjeta();
        }
    }

    public void accionVerificarTarjeta()
    {
        //Comando que verifique la validez de la tarjeta
    }

    public void accionConfirmarCompra()
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

    private void mostrarVistaDomicilios()
    {
        //Le pregunto si quiere que se entregue en ese domicilio
    }

    private void mostrarVistaNuevoDomicilio()
    {

    }

    private void mostrarVistaNuevaTarjeta()
    {
        //Le pido que ingrese los datos de la tarjeta
    }

    private void mostrarVistaMediosDePago()
    {

    }

    private void mostrarVistaTarjetas()
    {
        //Le pregunto si quiere pagar con esa tarjeta
    }

    private void informarSinStock()
    {
        //cartelito(Constantes.msg_sin_stock);
    }

    private void procesarSolicitud()
    {
        procesarSolicitud = new ComandoProcesarSolicitud(new SolicitudDeCompra());//instanciaSolicitud());
        switch (procesarSolicitud.ejecutar())
        {
            case 0:
                mostrarVistaPedidoOk();
                break;
            default:
                break;
        }
    }
}
