package pp2.app2.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 08/04/2017.
 */
public class CarritoTest {

    private Carrito carrito;

    @Before
    public void setUp() throws Exception {
        this.carrito = new Carrito();
    }

    @Test
    public void agregarItem() {
        assertTrue(this.carrito.agregarItem(new Producto(1, "manzana", 1)));
    }

    @Test
    public void eliminarItem(){
        assertTrue(this.carrito.eliminarItem(new Producto(1, "manzana", 1)));
    }

}