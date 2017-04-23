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
    Carrito carrito = dbTemp.getCarritoTemp();
    boolean sincronizacionExitosa;
    boolean sincronizacionFallida;

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
    public void hayQueSincronizar()
    {
        assertFalse(carrito.hayQueSincronizar());
        carrito.agregarItem(new Producto(99, "Shampoo", 99));
        assertTrue(carrito.hayQueSincronizar());
    }

    @Test
    public void SincronizacionExitosa()
    {
        //Si la respuesta de sincronizacion es correcta el carritoUOW debe estar limpio
        //Como la respuesta de sincronizacion es un boolean y no una sincronizacion real,
        //se usara el while para asegurarnos que haya una conexion erronea, y otro para una sincronizacion correcta.
        carrito.agregarItem(new Producto(99, "Shampoo", 99));
        while (!Conexion.sincronizar(carrito.getUOW()))
        {
            //Estoy aca
        }

    }
}
