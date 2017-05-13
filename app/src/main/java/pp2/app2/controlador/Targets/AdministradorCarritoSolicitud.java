package pp2.app2.controlador.Targets;

import pp2.app2.modelo.Producto;
import pp2.app2.modelo.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class AdministradorCarritoSolicitud {

    SolicitudDeCompra solicitud;

    public AdministradorCarritoSolicitud()
    {
        this.solicitud = new SolicitudDeCompra();
    }

    public SolicitudDeCompra administrar(Producto producto)
    {
        //Si hay stock agregar el producto, si no devolver la solicitud son productos.
        solicitud.agregarProducto(producto);
        return solicitud;
    }
}
