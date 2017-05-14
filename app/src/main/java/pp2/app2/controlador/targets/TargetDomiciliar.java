package pp2.app2.controlador.targets;

import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class TargetDomiciliar {

    SolicitudDeCompra solicitudDeCompra;

    public TargetDomiciliar () {
        this.solicitudDeCompra = new SolicitudDeCompra();
    }

    public SolicitudDeCompra administrar (Domicilio domicilio)  {
        this.solicitudDeCompra.setDomicilioEntrega(domicilio);
        return solicitudDeCompra;
    }
}
