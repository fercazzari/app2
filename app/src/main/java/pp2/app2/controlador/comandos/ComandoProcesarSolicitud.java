package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by jalvarez on 10/05/2017.
 */

public class ComandoProcesarSolicitud implements Command
{


    private SolicitudDeCompra solicitud;

    public ComandoProcesarSolicitud(SolicitudDeCompra solicitud)
    {
        this.solicitud = solicitud;
    }

    public int execute()
    // revisar stock y reservar la compra (del otro lado)
    {
        return 0;
    }
}
