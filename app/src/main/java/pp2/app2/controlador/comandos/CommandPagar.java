package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.Estado;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by fcazzari on 15/05/2017.
 */

public class CommandPagar {

    SolicitudDeCompra solicitudDeCompra;

    public CommandPagar() {
        this.solicitudDeCompra = new SolicitudDeCompra();
    }

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra, MedioDePago medioDePago)  {
        this.solicitudDeCompra = solicitudDeCompra;
        // this.solicitudDeCompra.pagar(medioDePago);
        this.solicitudDeCompra.agregarMedioDePago(medioDePago);
        this.solicitudDeCompra.setEstado(Estado.PAGADA);
        return this.solicitudDeCompra;
    }

}
