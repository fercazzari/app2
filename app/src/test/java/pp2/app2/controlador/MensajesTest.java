package pp2.app2.controlador;

import org.junit.Before;
import org.junit.Test;

import pp2.app2.modelo.app.Constantes;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 12/05/2017.
 */

public class MensajesTest {

    String actual, esperado;

    @Test
    public void informarErrorDeConexion() throws Exception {
        actual = Mensajes.informarErrorDeConexion(null);
        esperado = Constantes.msg_no_conexion;
        assertEquals(esperado, actual);
    }

    @Test
    public void informarErrorGeneral() throws Exception {
        actual = Mensajes.informarErrorGeneral(null);
        esperado = Constantes.msg_error_general;
        assertEquals(esperado, actual);
    }

    @Test
    public void informarFuncionalidadNoDisponible() throws Exception {
        actual = Mensajes.informarFuncionalidadNoDisponible(null);
        esperado = Constantes.msg_funcionalidad_no_disponible;
        assertEquals(esperado, actual);
    }

    @Test
    public void informarSinStock() throws Exception {
        actual = Mensajes.informarSinStock(null);
        esperado = Constantes.msg_sin_stock;
        assertEquals(esperado, actual);
    }

}