package pp2.app2.controlador.targets;

import pp2.app2.modelo.domain.Estado;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by fcazzari on 15/05/2017.
 */

public class TargetPagar {

    SolicitudDeCompra solicitudDeCompra;

    public TargetPagar () {
        this.solicitudDeCompra = new SolicitudDeCompra();
    }

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra, MedioDePago medioDePago)  {
        this.solicitudDeCompra = solicitudDeCompra;
        this.solicitudDeCompra.setMedioDePago(medioDePago);
        // this.solicitudDeCompra.pagar(medioDePago);
        this.solicitudDeCompra.setEstado(Estado.PAGADA);
        return this.solicitudDeCompra;
    }

}
