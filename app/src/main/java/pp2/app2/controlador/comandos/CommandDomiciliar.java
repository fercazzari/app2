package pp2.app2.controlador.comandos;

import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.SolicitudDeCompra;

/**
 * Created by Jony on 13/05/2017.
 */

public class CommandDomiciliar {

    public SolicitudDeCompra administrar (SolicitudDeCompra solicitudDeCompra, Domicilio domicilio)  {
        solicitudDeCompra.agregarDomicilio(domicilio);
        return solicitudDeCompra;
    }

}
