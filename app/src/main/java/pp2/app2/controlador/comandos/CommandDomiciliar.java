package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.Estado;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class CommandDomiciliar {

    SolicitudDeCompra solicitudDeCompra;

    public CommandDomiciliar() {
        this.solicitudDeCompra = new SolicitudDeCompra();
    }

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra, Domicilio domicilio)  {
        this.solicitudDeCompra = solicitudDeCompra;
        // this.solicitudDeCompra.setDomicilioEntrega(domicilio);
        this.solicitudDeCompra.agregarDomicilio(domicilio);
        return this.solicitudDeCompra;
    }

}
