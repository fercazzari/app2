package pp2.app2.controlador;

import pp2.app2.modelo.domain.Estado;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class MapProximaPantalla {

    public String obtenerProximaPantalla(SolicitudDeCompra solicitud)
    {
        if (solicitud.getEstado() == Estado.PAGADA)
        {
            return "vistaCompra";
        }
        else
        {
            //Una solicitud debe tener productos antes de pasar al paso del domicilio
             if(solicitud.getItems().isEmpty()) {
                return "sinProductos";
            }

            //Una solicitud debe tener productos y domicilio antes de pasar al paso del medio de pago
            if(solicitud.getDomicilioEntrega() == null) {
                return "vistaDomicilio";
            }

            if (solicitud.getMedioDePago() == null) {
                return "vistaPago";
            }

            if (solicitud.getMedioDePago() != null) {
                return "vistaCompra";
            }
        }
        return "errorGeneral";
    }
    /*
        switch (solicitud.getEstado()) {
            case VACIA:
                return "vistaProducto";
            case LLENA:
                return "vistaDomicilio";
            case DOMICILIADA:
                return "vistaPago";
            case PAGADA:
                return "vistaCompra";
            // case COMPRADA:
                // return "verCompraFinalizada";
        }
        return "errorGeneral";
    }
    */
}
