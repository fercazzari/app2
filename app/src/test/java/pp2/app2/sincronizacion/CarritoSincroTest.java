package pp2.app2.sincronizacion;

import org.junit.Test;

import pp2.app2.helpers.Constantes;
import pp2.app2.modelo.Carrito;
import pp2.app2.modelo.DatosTemp;
import pp2.app2.modelo.Producto;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jony on 23/04/2017.
 */

public class CarritoSincroTest {
    DatosTemp dbTemp = Constantes.dbTemp;
    Carrito carrito = dbTemp.getCarritoTemp();

    @Test
    public void agregarProductos()
    {
        assertTrue(carrito.getUOW().getNuevos().isEmpty());
        carrito.agregarItem(new Producto(99, "Shampoo", 99));
        assertFalse(carrito.getUOW().getNuevos().isEmpty());
    }

    @Test
    public void eliminarProductos()
    {
        assertTrue(carrito.getUOW().getEliminados().isEmpty());
        carrito.eliminarItem(carrito.getItems().remove(1));
        assertFalse(carrito.getUOW().getEliminados().isEmpty());
    }

    @Test
    public void sincronizarCarritoLocal()
    {
        //Si la respuesta de sincronizacion es correcta el carritoUOW debe estar limpio
    }
}
