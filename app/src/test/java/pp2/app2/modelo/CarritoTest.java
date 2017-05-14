package pp2.app2.modelo;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import pp2.app2.modelo.domain.Carrito;
import pp2.app2.modelo.domain.CarritoUOW;
import pp2.app2.modelo.app.DatosTemp;
import pp2.app2.modelo.domain.Producto;

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

    @Test
    public void hayQueSincronizar () {
        boolean esperado = false;
        boolean actual = this.carrito.getUOW().isEmpty();
        assertEquals(esperado, actual);
    }

    @Test
    public void sincronizado () {

    }

    @Test
    public void vaciar () {
        this.carrito.vaciar();
        assertTrue(this.carrito.getItems().isEmpty());
    }

    @Test
    public void getTotal () {
        this.carrito.agregarItem(datosTemp.obtenerProducto(100));
        this.carrito.agregarItem(datosTemp.obtenerProducto(101));
        double esperado = 30;
        double actual = this.carrito.getTotal();
        // TODO assertEquals()
    }

}