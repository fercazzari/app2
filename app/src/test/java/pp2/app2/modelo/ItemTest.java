package pp2.app2.modelo;

import org.junit.Before;
import org.junit.Test;

import pp2.app2.helpers.DatosTemp;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 11/05/2017.
 */
public class ItemTest {

    Item item;
    DatosTemp datosTemp;

    @Before
    public void setUp() throws Exception {
        this.datosTemp = new DatosTemp();
        this.item = new Item(datosTemp.obtenerProducto(100), 4);
    }

    @Test
    public void esProducto() throws Exception {
        boolean esperado, actual;
        esperado = false;
        actual = this.item.esProducto(datosTemp.obtenerProducto(100));
        assertEquals(esperado, actual);
    }

}