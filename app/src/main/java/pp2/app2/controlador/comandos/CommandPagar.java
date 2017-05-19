package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.Estado;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by fcazzari on 15/05/2017.
 */

public class CommandPagar {

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra, MedioDePago medioDePago)  {
        // this.solicitudDeCompra.pagar(medioDePago);
        solicitudDeCompra.agregarMedioDePago(medioDePago);
        solicitudDeCompra.setEstado(Estado.PAGO_ELEGIDO);
        return solicitudDeCompra;
    }

}
