package pp2.app2.compra;

import org.junit.Test;

import pp2.app2.controlador.CompraController;
import pp2.app2.modelo.app.DatosTemp;
import pp2.app2.modelo.domain.Domicilio;
import pp2.app2.modelo.domain.MedioDePago;
import pp2.app2.modelo.domain.Producto;
import pp2.app2.modelo.domain.SolicitudDeCompra;

import static org.junit.Assert.*;

/**
 * Created by Jony on 15/05/2017.
 */

public class CompraTest
{
    private static DatosTemp datosTemp = new DatosTemp();
    private static Producto producto = datosTemp.obtenerProducto(102);
    private static Domicilio domicilio = new Domicilio("Las Malvinas 4023");

    //Testear que al llamar al método del appController agregarProducto se obtiene una solicitud con el producto
    //entre sus items
    @Test
    public void agregarProductoTest()
    {
        SolicitudDeCompra solicitudVacia = new SolicitudDeCompra();
        CompraController.agregarProducto(null, solicitudVacia, producto);
        assertFalse(solicitudVacia.getItems().isEmpty());
        System.out.println(solicitudVacia.getItems().get(0));
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
        CompraController.confirmarMedioDePago(null, solicitudVacia, new MedioDePago("Tarjeta"));
        assertTrue(solicitudVacia.getMedioDePago() != null);
        assertEquals(solicitudVacia.getMedioDePago().toString(), "Tarjeta");
    }
}
