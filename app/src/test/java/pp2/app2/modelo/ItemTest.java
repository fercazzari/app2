package pp2.app2.modelo;

import org.junit.Before;
import org.junit.Test;

import pp2.app2.modelo.app.DatosTemp;
import pp2.app2.modelo.domain.Item;
import pp2.app2.modelo.domain.Producto;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 11/05/2017.
 */
public class ItemTest {

    Item item;
    DatosTemp datosTemp;
    Producto actual, esperado;
    int i_actual, i_esperado;

    @Before
    public void setUp() throws Exception {
        this.datosTemp = new DatosTemp();
        this.item = new Item(datosTemp.obtenerProducto(100), 4);
    }

    @Test
    public void test() throws Exception {
        actual = this.item.getProducto();
        esperado = datosTemp.obtenerProducto(100);
        assertEquals(esperado, actual);

        i_actual = this.item.getCantidad();
        i_esperado = 4;
        assertEquals(i_esperado, i_actual);

        this.item.agregarUnidad(new Item(datosTemp.obtenerProducto(100), 2));
        i_actual = this.item.getCantidad();
        i_esperado = 6;
    }

}