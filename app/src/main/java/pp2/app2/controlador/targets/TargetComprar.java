package pp2.app2.controlador.targets;

import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by fcazzari on 15/05/2017.
 */

public class TargetComprar {

    SolicitudDeCompra solicitudDeCompra;

    public TargetComprar () {
        this.solicitudDeCompra = new SolicitudDeCompra();
    }

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra)  {

        this.solicitudDeCompra = solicitudDeCompra;
        return solicitudDeCompra;

    }

}
