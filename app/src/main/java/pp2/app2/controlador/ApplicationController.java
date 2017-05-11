package pp2.app2.controlador;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.CopyOnWriteArrayList;

import pp2.app2.activities.CompraActivity;
import pp2.app2.controlador.Comandos.ComandoPedido;
import pp2.app2.controlador.Comandos.ComandoMostrarProducto;
import pp2.app2.controlador.Comandos.ComandoProcesarSolicitud;
import pp2.app2.helpers.IdentityField;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.Domicilio;
import pp2.app2.modelo.Producto;
import pp2.app2.modelo.SolicitudDeCompra;

/**
 * Created by fcazzari on 05/05/2017.
 */

public class ApplicationController {

    private static ComandoPedido pedido;
    private static ComandoMostrarProducto mostrarProducto;
    private static ComandoProcesarSolicitud procesarSolicitud;

    public static void accionBtnPrepararPedido(Producto producto)
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

    public static void accionEntregarEnOtroDomicilio()
    {
        //Mostrar vista para ingresar domicilio
        mostrarVistaNuevoDomicilio();
    }

    public static void accionAceptarDomicilioDeEntrega(Domicilio domicilioDeEntrega)
    {
        //Falta mucho codigo
        //Instanciar solicitud
        //Agregarle el domicilio
        mostrarVistaMediosDePago();
    }

    public static void accionAceptarPagoEnEfectivo()
    {

    }

    public static void accionPagoConTarjeta()
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

    public static void accionVerificarTarjeta()
    {
        //Comando que verifique la validez de la tarjeta
    }

    public static void accionConfirmarCompra()
    {

    }

    public static void accionBtnDetalles(Producto producto)
    {
        //Analizar de que vista viene si es necesario
        mostrarProducto = new ComandoMostrarProducto(producto);
        Producto productoConDetalles = mostrarProducto.obtenerDetalles();
        //Llamar a la vista correspondiente vista(productoConDetalles)
    }

    private static void mostrarVistaPedidoOk()
    {
        // se compro el producto
        // kill toda la vista anterior
        // kill solicitud de compra. o clear bc va a ser singleton

        

    }

    private static void mostrarVistaDomicilios()
    {
        //Le pregunto si quiere que se entregue en ese domicilio
    }

    private static void mostrarVistaNuevoDomicilio()
    {

    }

    private static void mostrarVistaNuevaTarjeta()
    {
        //Le pido que ingrese los datos de la tarjeta
    }

    private static void mostrarVistaMediosDePago()
    {

    }

    private static void mostrarVistaTarjetas()
    {
        //Le pregunto si quiere pagar con esa tarjeta
    }

    private static void informarSinStock()
    {
        //cartelito(Constantes.msg_sin_stock);
    }

    private static void procesarSolicitud()
    {
        procesarSolicitud = new ComandoProcesarSolicitud(new SolicitudDeCompra());//instanciaSolicitud());
        switch (procesarSolicitud.execute())
        {
            case 0:
                mostrarVistaPedidoOk();
                break;
            default:
                break;
        }
    }

}
