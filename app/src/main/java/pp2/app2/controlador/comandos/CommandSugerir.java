package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by fcazzari on 19/05/2017.
 */

public class CommandSugerir {

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra)  {

        solicitudDeCompra.finalizar();
        return solicitudDeCompra;

    }

}
