package pp2.app2.controlador.targets;

import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class TargetAgregarProducto {

    SolicitudDeCompra solicitud;

    public TargetAgregarProducto() {
        this.solicitud = new SolicitudDeCompra();
    }

    public SolicitudDeCompra administrar(Producto producto)
    {
        //Si hay stock agregar el producto, si no devolver la solicitud son productos.
        solicitud.agregarProducto(producto);
        return solicitud;
    }
}
