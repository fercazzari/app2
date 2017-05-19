package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.Estado;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by fcazzari on 15/05/2017.
 */

public class CommandComprar {

    SolicitudDeCompra solicitudDeCompra;

    public CommandComprar() {
        this.solicitudDeCompra = new SolicitudDeCompra();
    }

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra)  {

        this.solicitudDeCompra = solicitudDeCompra;
        this.solicitudDeCompra.finalizar();
        return this.solicitudDeCompra;

    }

}
