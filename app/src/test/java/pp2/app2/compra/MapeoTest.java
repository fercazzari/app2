package pp2.app2.compra;

import org.junit.Test;

import pp2.app2.controlador.MapProximaPantalla;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.Estado;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;
import pp2.app2.modelo.domain.Tarjeta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Jony on 15/05/2017.
 */

public class MapeoTest
{
    private MapProximaPantalla map = new MapProximaPantalla();
    private SolicitudDeCompra solicitud = new SolicitudDeCompra();

    //Testear que si la solicitud de compra no tiene domicilio de entrega pero si items se muestra la pantalla para elegir domicilio
    @Test
    public void proximaPantallaDomicilioTest()
    {
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaDomicilio");
        solicitud.agregarProducto(new Producto());
        assertEquals(map.obtenerProximaPantalla(solicitud), "vistaDomicilio");
    }

    //Testear que si la solicitud de compra tiene productos y domicilio pero no medio de pago, se debe pedir el medio de pago
    @Test
    public void ProximaPantallaMedioDePagoTest()
    {
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaPago");
        solicitud.agregarProducto(new Producto());
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaPago");
        solicitud.agregarDomicilio(new Domicilio("Calle falsa 123"));
        assertEquals(map.obtenerProximaPantalla(solicitud), "vistaPago");
    }

    //Testear que si la solicitud de compra tiene medio de pago, items y domicilio se muestra la pantalla para confirmar compra
    @Test
    public void ProximaPantallaFinalizarCompraTest()
    {
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaCompra");
        solicitud.agregarProducto(new Producto());
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaCompra");
        solicitud.agregarDomicilio(new Domicilio("Calle falsa 123"));
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaCompra");
        solicitud.agregarMedioDePago(new Tarjeta("XXXX-XXXX-XXXX-XXXX"));
        assertEquals(map.obtenerProximaPantalla(solicitud), "vistaCompra");
    }

    @Test
    public void ProximaPantallaCompraFinalizadaTest()
    {
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaCompraFinalizada");
        solicitud.agregarProducto(new Producto());
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaCompraFinalizada");
        solicitud.agregarDomicilio(new Domicilio("Calle falsa 123"));
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaCompraFinalizada");
        solicitud.agregarMedioDePago(new Tarjeta("XXXX-XXXX-XXXX-XXXX"));
        assertNotEquals(map.obtenerProximaPantalla(solicitud), "vistaCompraFinalizada");
        solicitud.setEstado(Estado.FINALIZADA);
        assertEquals(map.obtenerProximaPantalla(solicitud), "vistaCompraFinalizada");
    }
}
