package pp2.app2.sincronizacion;

import org.junit.Test;

import pp2.app2.helpers.Conexion;
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
    boolean sincronizacionExitosa;
    boolean sincronizacionFallida;

    @Test
    public void agregarProductos()
    {
        Carrito carritoTest = dbTemp.getCarritoTemp();
        assertTrue(carritoTest.getUOW().getNuevos().isEmpty());
        carritoTest.agregarItem(new Producto(99, "Shampoo", 99));
        assertFalse(carritoTest.getUOW().getNuevos().isEmpty());
    }

    @Test
    public void eliminarProductos()
    {
        Carrito carritoTest = dbTemp.getCarritoTemp();
        assertTrue(carritoTest.getUOW().getEliminados().isEmpty());
        carritoTest.eliminarItem(carritoTest.getItems().remove(0));
        assertFalse(carritoTest.getUOW().getEliminados().isEmpty());
    }

    @Test
    public void hayQueSincronizar()
    {
        Carrito carritoTest = dbTemp.getCarritoTemp();
        assertFalse(carritoTest.hayQueSincronizar());
        carritoTest.agregarItem(new Producto(99, "Shampoo", 99));
        assertTrue(carritoTest.hayQueSincronizar());
    }

    @Test //1
    public void SincronizacionExitosa()
    {
        //Si la respuesta de sincronizacion es correcta el carritoUOW debe estar limpio
        //Como la respuesta de sincronizacion es un boolean y no una sincronizacion real,
        //se usara el while para asegurarnos que haya una conexion correcta.
        Carrito carritoTest = dbTemp.getCarritoTemp();
        carritoTest.agregarItem(new Producto(99, "Shampoo", 99));
        while (!Conexion.sincronizar(carritoTest.getUOW()))
        {
            assertFalse(carritoTest.getUOW().isEmpty());
            sincronizacionExitosa = Conexion.sincronizar(carritoTest.getUOW());
        }
        carritoTest.sincronizado();
        assertTrue(carritoTest.getUOW().isEmpty());
    }

    @Test //2
    public void SincronizacionErronea()
    {
        //Si la respuesta de sincronizacion es correcta el carritoUOW debe estar limpio
        //Como la respuesta de sincronizacion es un boolean y no una sincronizacion real,
        //se usara el while para asegurarnos que haya una conexion erronea.
        Carrito carritoTest = dbTemp.getCarritoTemp();
        while (Conexion.sincronizar(carritoTest.getUOW()))
        {
            carritoTest.sincronizado();
            carritoTest.agregarItem(new Producto(99, "Shampoo", 99));
            assertTrue(carritoTest.getUOW().isEmpty());
            sincronizacionExitosa = Conexion.sincronizar(carritoTest.getUOW());
        }
        assertFalse(carritoTest.getUOW().isEmpty());
    }

    @Test //3
    public void sincronizarCarritoVacio()
    {
        Carrito carritoTest = dbTemp.getCarritoTemp();
        assertFalse(carritoTest.getItems().isEmpty());
        carritoTest.vaciar();
        assertTrue(carritoTest.getItems().isEmpty());
        assertTrue(carritoTest.hayQueSincronizar());
    }

    @Test //4 y 5 Podes chequear si hay conexion, pero no si sincroniza o no hasta que
    //el metodo de sincronizar no este afuera del activity.
    public void probarConexion()
    {
        assertFalse(Conexion.hayConexion(null));
    }

    @Test //6
    public void carritoSinCambiosAddRemove()
    {
        Carrito nuevoCarritoTest = new Carrito();
        assertFalse(nuevoCarritoTest.hayQueSincronizar());
        nuevoCarritoTest.agregarItem(new Producto(99, "Shampoo", 99));
        assertTrue(nuevoCarritoTest.hayQueSincronizar());
        nuevoCarritoTest.eliminarItem(new Producto(99, "Shampoo", 99));
        assertFalse(nuevoCarritoTest.hayQueSincronizar());
    }

    @Test //6.2
    public void carritoSinCambiosRemoveAdd()
    {
        Carrito carritoTest = dbTemp.getCarritoTemp();
        //Suponemos que se realizo la sincronizacion ok
        carritoTest.sincronizado();
        Producto productoEliminado = carritoTest.getItems().get(0);
        assertTrue(carritoTest.hayQueSincronizar());
        carritoTest.agregarItem(productoEliminado);
        assertFalse(carritoTest.hayQueSincronizar());
    }
}
