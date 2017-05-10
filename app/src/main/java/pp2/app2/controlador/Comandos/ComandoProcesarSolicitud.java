package pp2.app2.controlador.Comandos;

import pp2.app2.modelo.SolicitudDeCompra;

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

    public int execute() {
        return 0;
    }
}
