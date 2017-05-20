package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class CommandAgregarProducto {

    public SolicitudDeCompra administrar(SolicitudDeCompra solicitud, Producto producto)
    {
        //Si hay stock agregar el producto, si no devolver la solicitud sin productos.
        solicitud.agregarProducto(producto);
        return solicitud;
    }
}
