package pp2.app2.modelo;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import pp2.app2.helpers.CarritoUOW;
import pp2.app2.helpers.IdentityField;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 08/04/2017.
 */
public class CarritoTest {

    private Carrito carrito;
    DatosTemp datosTemp;

    @Before
    public void setUp() throws Exception {
        this.carrito = new Carrito();
        this.datosTemp = new DatosTemp();
        assertTrue(this.carrito.agregarItem(datosTemp.obtenerProducto(100)));
    }

    @Test
    public void agregarItem() {
        assertTrue(this.carrito.agregarItem(datosTemp.obtenerProducto(101)));
    }

    @Test
    public void eliminarItem () {
        assertTrue(!this.carrito.getItems().isEmpty());
        this.carrito.eliminarItem(datosTemp.obtenerProducto(101));
    }

    @Test
    public void getCantidad() {
        int esperado = 1;
        int actual = this.carrito.getCantidad();
        assertEquals(esperado, actual);
    }

    @Test
    public void getItems() {
        List<Producto> esperado = new LinkedList<Producto>();
        List<Producto> incorrecto = new LinkedList<Producto>();
        List<Producto> actual = this.carrito.getItems();

        esperado.add(datosTemp.obtenerProducto(100));

        assertEquals(esperado, actual);
        assertNotEquals(incorrecto, actual);
    }

    @Test
    public void getUOW () {
        CarritoUOW esperado = new CarritoUOW();
        CarritoUOW actual = this.carrito.getUOW();
        // TODO
    }

}