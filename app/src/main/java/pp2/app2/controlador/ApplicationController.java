package pp2.app2.controlador;

import android.content.Context;

import pp2.app2.controlador.comandos.ComandoMostrarProducto;
import pp2.app2.controlador.comandos.ComandoPedido;
import pp2.app2.controlador.comandos.ComandoProcesarSolicitud;
import pp2.app2.controlador.targets.TargetAgregarProducto;
import pp2.app2.controlador.targets.TargetComprar;
import pp2.app2.controlador.targets.TargetDomiciliar;
import pp2.app2.controlador.targets.TargetPagar;
import pp2.app2.modelo.domain.Carrito;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;
import pp2.app2.presenter.CompraPresenter;
import pp2.app2.presenter.DomicilioPresenter;
import pp2.app2.presenter.PagoPresenter;

/**
 * Created by fcazzari on 05/05/2017.
 */

public class ApplicationController {

    private static ComandoPedido pedido;
    private static ComandoMostrarProducto mostrarProducto;
    private static ComandoProcesarSolicitud procesarSolicitud;

    private static MapProximaPantalla map = new MapProximaPantalla();
    private static SolicitudDeCompra solicitud;

    private static DomicilioPresenter domicilioPresenter = new DomicilioPresenter();
    private static PagoPresenter pagoPresenter = new PagoPresenter();
    private static CompraPresenter compraPresenter = new CompraPresenter();

    public static void agregarProducto (Context contexto, Producto producto)
    {
        solicitud = new TargetAgregarProducto().administrar(producto);
        mostrarProximaVista(contexto, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarDomicilio (Context context, SolicitudDeCompra solicitudDeCompra, Domicilio domicilio) {
        solicitud = new TargetDomiciliar().administrar(solicitudDeCompra, domicilio);
        mostrarProximaVista(context, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarMedioDePago (Context context, SolicitudDeCompra solicitud, MedioDePago medioDePago) {
        solicitud = new TargetPagar().administrar(solicitud, medioDePago);
        mostrarProximaVista(context, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarCompra (Context context, SolicitudDeCompra solicitud) {
        solicitud = new TargetComprar().administrar(solicitud);
        mostrarProximaVista(context, map.obtenerProximaPantalla(solicitud));
    }


    private static void mostrarProximaVista(Context contexto, String proximaVista)
    {
        switch(proximaVista) {
            //Listar las vistas
            case "sinProductos":
                // mainPresenter.armarVista(contexto);
                break;
            case "elegirDomicilio":
                domicilioPresenter.armarVista(contexto, solicitud);
                break;
            case "medioDePago":
                pagoPresenter.armarVista(contexto, solicitud);
                break;
            case "finalizarCompra":
                compraPresenter.armarVista(contexto, solicitud);

            default:
                break;
        }
    }

    public static void prepararPedido (Context contexto, Producto producto) {

        Carrito carrito = new Carrito();
        carrito.agregarItem(producto);

        pedido = new ComandoPedido(carrito);

        switch(pedido.execute()) {
            case 0:
                /*
                  Caso básico para comprar. Después:
                  - agregar un domicilio de entrega
                  - instanciar la solicitud (siempre va a estar en memoria)
                  - agregarle el producto
                  - llamar a la vista correspondiente
                 */
                // procesarSolicitud(contexto, producto);
                /*
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
                Mensajes.informarSinStock(contexto);
                break;
            case 2:
                Mensajes.informarErrorDeConexion(contexto);
                break;
            default:
                Mensajes.informarErrorGeneral(contexto);
                break;
        }
    }

    /* public static void accionEntregarEnOtroDomicilio() {
        //Mostrar vista para ingresar domicilio
        mostrarVistaNuevoDomicilio();
    }

    public static void accionAceptarDomicilioDeEntrega(Domicilio domicilioDeEntrega) {
        //Falta mucho codigo
        //Instanciar solicitud
        //Agregarle el domicilio
        mostrarVistaMediosDePago();
    }

    public static void accionAceptarPagoEnEfectivo() {

    }

    public static void accionPagoConTarjeta() {
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

    private static void procesarSolicitud(Context context, Producto producto)
    {
        procesarSolicitud = new ComandoProcesarSolicitud(new SolicitudDeCompra());//instanciaSolicitud());
        switch (procesarSolicitud.execute()) // si hay stock
        {
            case 0:
                // mostrarVistaCompra(context, producto);
            default:
                break;
        }
    }
    */
}
