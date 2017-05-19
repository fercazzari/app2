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

        if (solicitud.getEstado() == Estado.LISTA) {
            return "vistaSugerencia";
        }

        if (solicitud.getEstado() == Estado.FINALIZADA) {
            return "vistaCompraFinalizada";
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

}
