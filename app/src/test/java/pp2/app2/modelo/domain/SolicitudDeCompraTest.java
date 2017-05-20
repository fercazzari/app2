package pp2.app2.modelo.domain;

import org.junit.Before;
import org.junit.Test;

import pp2.app2.modelo.app.DatosTemp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by fcazzari on 11/05/2017.
 */
public class SolicitudDeCompraTest {

    DatosTemp datosTemp;
    SolicitudDeCompra solicitudDeCompra;
    String actual, esperado;

    @Before
    public void setUp() throws Exception {
        this.datosTemp = new DatosTemp();
        this.solicitudDeCompra = new SolicitudDeCompra();
    }

    @Test
    public void agregarProducto() throws Exception {
        this.solicitudDeCompra.agregarProducto(datosTemp.obtenerProducto(102));
        int esperado, actual;
        esperado = 1;
        actual = this.solicitudDeCompra.getItems().size();
        assertTrue(esperado == actual);
    }

    @Test
    public void test() {
        this.solicitudDeCompra.agregarDomicilio(new Domicilio("Calle 123"));
        this.solicitudDeCompra.setDomicilioEntrega(new Domicilio("Calle 123"));
        actual = this.solicitudDeCompra.getDomicilioEntrega().getDatos();
        esperado = "Calle 123";
        assertEquals(esperado, actual);

        this.solicitudDeCompra.agregarMedioDePago(new MercadoPago("Visa"));
        this.solicitudDeCompra.setMedioDePago(new MercadoPago("Visa"));
        actual = this.solicitudDeCompra.getMedioDePago().toString();
        esperado = "MercadoPago";
        assertEquals(esperado, actual);

        this.solicitudDeCompra.setEstado(Estado.FINALIZADA);
        actual = this.solicitudDeCompra.getEstado().toString();
        esperado = "FINALIZADA";

        actual = String.valueOf(this.solicitudDeCompra.calcularTotal());
        esperado = String.valueOf(0);
        assertEquals(esperado, actual);
    }
}