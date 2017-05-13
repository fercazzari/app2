package pp2.app2.controlador;

import pp2.app2.modelo.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class MapProximaPantalla
{

    public String obtenerProximaPantalla(SolicitudDeCompra solicitud)
    {
        if(solicitud.getItems().isEmpty())
        {
            return "sinProductos";
        }
        if(solicitud.getDomicilioEntrega() == null)
        {
            return "agregarDomicilio";
        }
        return "";
    }
}
