package pp2.app2.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 09/04/2017.
 */
public class ProductoTest {

    private Producto producto;

    @Before
    public void setUp() throws Exception {
        this.producto = new Producto(1, "manzana", 1);
    }

    @Test
    public void getNombre () {
        assertEquals(this.producto.getNombre(), "manzana");
    }

    @Test
    public void getId () {
        assertEquals(this.producto.getId(), 1);
    }

    @Test
    public void getIdCategoria() {
        assertEquals(this.producto.getIdCategoria(), 1);
    }
}