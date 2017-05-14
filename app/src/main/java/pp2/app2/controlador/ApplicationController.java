package pp2.app2.controlador;

import android.content.Context;
import android.content.Intent;

import pp2.app2.activities.CompraActivity;
import pp2.app2.activities.CompraFinalizadaActivity;
import pp2.app2.activities.ProductoActivity;
import pp2.app2.activities.SugerenciaActivity;
import pp2.app2.controlador.comandos.ComandoMostrarProducto;
import pp2.app2.controlador.comandos.ComandoPedido;
import pp2.app2.controlador.comandos.ComandoProcesarSolicitud;
import pp2.app2.controlador.targets.TargetAgregarProducto;
import pp2.app2.controlador.targets.TargetDomiciliar;
import pp2.app2.modelo.domain.Carrito;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;
import pp2.app2.presenter.DomicilioPresenter;
import pp2.app2.presenter.MainPresenter;
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
    private static MainPresenter mainPresenter = new MainPresenter();

    public static void agregarProducto (Context contexto, Producto producto)
    {
        solicitud = new TargetAgregarProducto().administrar(producto);
        mostrarProximaVista(contexto, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarDomicilio (Context context, Domicilio domicilio) {
        solicitud = new TargetDomiciliar().administrar(domicilio);
        mostrarProximaVista(context, map.obtenerProximaPantalla(solicitud));
    }

    private static void mostrarProximaVista(Context contexto, String proximaVista)
    {
        switch(proximaVista) {
            //Listar las vistas
            case "sinProductos":
                mainPresenter.armarVista(contexto);
                break;
            case "elegirDomicilio":
                domicilioPresenter.armarVista(contexto, solicitud);
                break;
            case "medioDePago":
                pagoPresenter.armarVista(contexto, solicitud);
                break;
            default:
                break;
        }
    }

    /* public static void recibirCommand (String command, Context contexto, Producto producto) {

        switch (command) {
            case "menuComprar":
                mostrarVistaVerProducto(contexto, producto);
                break;
            case "verSugerencias":
                mostrarVistaSugerencias(contexto, producto);
                break;
            case "omitirSugerencia":
                mostrarVistaCompra(contexto, producto);
                break;
            case "aceptarSugerencia":
                break;
            case "verCompraFinalizada":
                mostrarCompraFinalizada(contexto, producto);
                break;
        }
    } */

    /* public static void mostrarVistaCompra (Context context, Producto producto) {

        // kill toda la vista anterior
        // kill solicitud de compra. o clear bc va a ser singleton

        Intent i = new Intent(context, CompraActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        i.putExtra("id_producto", String.valueOf(producto.getId().getField()));
        i.putExtra("nombre_producto", producto.getNombre());
        i.putExtra("precio_producto", String.valueOf(producto.getPrecio()));

        context.startActivity( i );
    } */

    public static void mostrarVistaCompra (Context context, Producto producto) {

//        Producto producto = solicitud.getItems().get(0).getProducto();

        Intent i = new Intent(context, CompraActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        i.putExtra("id_producto", String.valueOf(producto.getId().getField()));
        i.putExtra("nombre_producto", producto.getNombre());
        i.putExtra("precio_producto", String.valueOf(producto.getPrecio()));

        context.startActivity( i );
    }
    public static void mostrarVistaSugerencias(Context context, Producto producto) {

        Intent i = new Intent(context, SugerenciaActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        i.putExtra("id_producto", String.valueOf(producto.getId().getField()));
        i.putExtra("nombre_producto", producto.getNombre());
        i.putExtra("precio_producto", String.valueOf(producto.getPrecio()));

        context.startActivity( i );
    }

    public static void mostrarCompraFinalizada (Context context, Producto producto) {

        Intent i = new Intent(context, CompraFinalizadaActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity( i );
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
                procesarSolicitud(contexto, producto);
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

    public static void mostrarVistaVerProducto(Context context, Producto producto) {

        Intent i = new Intent(context, ProductoActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity( i );

    }

    public static void mostrarVistaRecomendacion (Context context, Producto producto) {

        /* Intent i = new Intent(context, RecomendadosActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity( i );
        */

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

}
