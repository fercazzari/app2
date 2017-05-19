package pp2.app2.controlador;

import android.content.Context;

import pp2.app2.controlador.comandos.CommandAgregarProducto;
import pp2.app2.controlador.comandos.CommandComprar;
import pp2.app2.controlador.comandos.CommandDomiciliar;
import pp2.app2.controlador.comandos.CommandPagar;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;
import pp2.app2.presenter.CompraFinalizadaPresenter;
import pp2.app2.presenter.CompraPresenter;
import pp2.app2.presenter.DomicilioPresenter;
import pp2.app2.presenter.PagoPresenter;
import pp2.app2.presenter.ProductoPresenter;

/**
 * Created by fcazzari on 05/05/2017.
 */

public class ApplicationController {


    private static MapProximaPantalla map = new MapProximaPantalla();

    private static ProductoPresenter productoPresenter = new ProductoPresenter();
    private static DomicilioPresenter domicilioPresenter = new DomicilioPresenter();
    private static PagoPresenter pagoPresenter = new PagoPresenter();
    private static CompraPresenter compraPresenter = new CompraPresenter();
    private static CompraFinalizadaPresenter compraFinalizadaPresenter = new CompraFinalizadaPresenter();

    public static void agregarProducto (Context contexto, SolicitudDeCompra solicitud, Producto producto)
    {
        solicitud = new CommandAgregarProducto().administrar(producto);
        mostrarProximaVista(contexto, solicitud, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarDomicilio (Context context, SolicitudDeCompra solicitud, Domicilio domicilio) {
        solicitud = new CommandDomiciliar().administrar(solicitud, domicilio);
        mostrarProximaVista(context, solicitud, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarMedioDePago (Context context, SolicitudDeCompra solicitud, MedioDePago medioDePago) {
        solicitud = new CommandPagar().administrar(solicitud, medioDePago);
        mostrarProximaVista(context, solicitud, map.obtenerProximaPantalla(solicitud));
    }

    public static void confirmarCompra (Context context, SolicitudDeCompra solicitud) {
        solicitud = new CommandComprar().administrar(solicitud);
        mostrarProximaVista(context, solicitud, map.obtenerProximaPantalla(solicitud));
    }


    private static void mostrarProximaVista(Context contexto, SolicitudDeCompra solicitud, String proximaVista)
    {
        if(contexto != null)    //Para los test.
        {
            switch(proximaVista) {
                //Listar las vistas
                case "sinProductos":
                    productoPresenter.armarVista(contexto, null, "Sin Stock");
                    break;
                case "vistaProducto":
                    // productoPresenter.armarVista(contexto);
                    break;
                case "vistaDomicilio":
                    domicilioPresenter.armarVista(contexto, solicitud);
                    break;
                case "vistaPago":
                    pagoPresenter.armarVista(contexto, solicitud);
                    break;
                case "vistaCompra":
                    compraPresenter.armarVista(contexto, solicitud);
                /* case "verCompraFinalizada":
                    compraFinalizadaPresenter.armarVista(contexto, solicitud);
                    break; */
                default:
                    break;
            }
        }
    }
}
