package pp2.app2.compra;

import org.junit.Test;

import pp2.app2.controlador.CompraController;
import pp2.app2.modelo.app.DatosTemp;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.Estado;
import pp2.app2.modelo.domain.Item;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;
import pp2.app2.modelo.domain.Tarjeta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jony on 15/05/2017.
 */

public class CompraTest
{
    private static DatosTemp datosTemp = new DatosTemp();
    private static Producto productoConStock = datosTemp.obtenerProducto(102);
    private static Producto productoSinStock = datosTemp.obtenerProducto(100);
    private static Domicilio domicilio = new Domicilio("Las Malvinas 4023");

    //Testear que al llamar al método del appController agregarProducto se obtiene una solicitud con el producto
    //entre sus items
    @Test
    public void agregarProductoTest()
    {
        SolicitudDeCompra solicitudVacia = new SolicitudDeCompra();
        CompraController.agregarProducto(null, solicitudVacia, productoConStock);
        assertFalse(solicitudVacia.getItems().isEmpty());
        boolean contiene = false;
        for (Item i : solicitudVacia.getItems())
            if (i.getProducto().equals(productoConStock))
                contiene = true;
        assertTrue(contiene);
    }

    //Testear que al intentar agregar un producto a una solicitud, si no hay stock, no se agregue a la solicitud
    @Test
    public void agregarProductoSolicitud()
    {
        SolicitudDeCompra solicitudVacia = new SolicitudDeCompra();
        solicitudVacia.agregarProducto(productoSinStock);
        assertTrue(solicitudVacia.getItems().isEmpty());
    }
    
    @Test
    public void agregarVariosProductoSolicitud()
    {
        SolicitudDeCompra solicitud = new SolicitudDeCompra();
        solicitudVacia.agregarProducto(productoConStock);
        assertFalse(solicitud.getItems().isEmpty());
        solicitudVacia.agregarProducto(productoConStock);
        assertTrue(solicitud.getItems().size(), 2);
    }

    //Testear que al llamar al método del appController confirmarDomicilio se obtiene una solicitud con el domicilio dado
    @Test
    public void confirmarDomicilioTest()
    {
        SolicitudDeCompra solicitudVacia = new SolicitudDeCompra();
        CompraController.confirmarDomicilio(null, solicitudVacia, domicilio);
        assertTrue(solicitudVacia.getDomicilioEntrega() != null);
        assertEquals(solicitudVacia.getDomicilioEntrega(), domicilio);
    }

    //Testear que al llamar al método del appCpntroller confirmarMedioDePago se obtiene una solicitud con el medioDePagoInformado
    @Test
    public void confirmarMedioDePagoTest()
    {
        SolicitudDeCompra solicitudVacia = new SolicitudDeCompra();
        CompraController.confirmarMedioDePago(null, solicitudVacia, new Tarjeta("XXXX-XXXX-XXXX-XXXX"));
        assertTrue(solicitudVacia.getMedioDePago() != null);
        assertEquals(solicitudVacia.getMedioDePago().toString(), "Tarjeta");
    }

    @Test
    public void confirmarCompraTest()
    {
        Estado esperado, actual;
        SolicitudDeCompra solicitudVacia = new SolicitudDeCompra();
        CompraController.confirmarCompra(null, solicitudVacia);
        esperado = Estado.FINALIZADA;
        actual = solicitudVacia.getEstado();
        assertEquals(esperado, actual);
    }
}
