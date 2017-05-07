package pp2.app2.modelo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pp2.app2.helpers.IdentityField;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 09/04/2017.
 */
public class ProductoTest {

        DatosTemp datosTemp;
        private Producto producto;
        private Producto igual;
        private Producto distinto;
        private Producto vacio;

        @Before
        public void setUp() throws Exception {
            this.datosTemp = new DatosTemp();
            this.producto = datosTemp.obtenerProducto(100);
            this.igual = datosTemp.obtenerProducto(100);
            this.distinto = datosTemp.obtenerProducto(101);
            this.vacio = new Producto();
        }

        @Test
        public void getIdProducto () {
            Integer esperado = 100;
            Integer actual = this.producto.getId().getField();
            assertEquals(esperado, actual);
        }

        @Test
        public void getNombre () {
            String esperado = "anana";
            String actual = this.producto.getNombre();
            assertEquals(esperado, actual);

            assertTrue(this.producto.getNombre().equals(this.igual.getNombre()));
            assertTrue(!this.producto.getNombre().equals(this.distinto.getNombre()));
        }

        @Test
        public void equals() {
            assertTrue(this.producto.equals(this.igual));
            assertTrue(!this.producto.equals(this.distinto));
        }

    @Test
    public void test () {
        int id_esperado = 100;
        int id_actual = this.producto.getId().getField();
        String nombre_esperado = "anana";
        String nombre_actual = this.producto.getNombre();

        assertEquals(id_esperado, id_actual);
        assertEquals(nombre_esperado, nombre_actual);

        String str_esperado = "anana";
        String str_actual = this.producto.toString();
        assertEquals(str_esperado, str_actual);

        id_esperado = 0;
        id_actual = this.vacio.getId().getField();
        nombre_esperado = "";
        nombre_actual = this.vacio.getNombre();

        assertEquals(id_esperado, id_actual);
        assertEquals(nombre_esperado, nombre_actual);

    }

}