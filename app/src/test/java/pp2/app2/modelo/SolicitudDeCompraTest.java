package pp2.app2.modelo;

import org.junit.Before;
import org.junit.Test;

import pp2.app2.modelo.app.DatosTemp;
import pp2.app2.modelo.domain.SolicitudDeCompra;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 11/05/2017.
 */
public class SolicitudDeCompraTest {

    DatosTemp datosTemp;
    SolicitudDeCompra solicitudDeCompra;

    @Before
    public void setUp() throws Exception {
        this.datosTemp = new DatosTemp();
        this.solicitudDeCompra = new SolicitudDeCompra();
    }

    @Test
    public void agregarProducto() throws Exception {
        this.solicitudDeCompra.agregarProducto(datosTemp.obtenerProducto(100));
        int esperado, actual;
        esperado = 1;
        actual = this.solicitudDeCompra.getItems().size();
        assertTrue(esperado == actual);
    }

}