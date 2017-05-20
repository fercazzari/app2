package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by fcazzari on 15/05/2017.
 */

public class CommandComprar {

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra)  {

        solicitudDeCompra.finalizar();
        return solicitudDeCompra;

    }

}
