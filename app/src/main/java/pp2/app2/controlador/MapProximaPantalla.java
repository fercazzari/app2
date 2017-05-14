package pp2.app2.controlador;

import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class MapProximaPantalla
{

    public String obtenerProximaPantalla(SolicitudDeCompra solicitud)
    {
        //Una solicitud debe tener productos antes de pasar al paso del domicilio
        if(solicitud.getItems().isEmpty())
        {
            return "sinProductos";
        }
        //Una solicitud debe tener productos y domicilio antes de pasar al paso del medio de pago
        if(solicitud.getDomicilioEntrega() == null)
        {
            return "agregarDomicilio";
        }
        return "errorGeneral";
    }
}
