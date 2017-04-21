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
        private Producto igual;
        private Producto distinto;
        private Producto vacio;

        @Before
        public void setUp() throws Exception {
            this.producto = new Producto(1, "anana", 1);
            this.igual = new Producto(1, "anana", 1);
            this.distinto = new Producto(2, "manzana", 2);
            this.vacio = new Producto();
        }

        @Test
        public void getIdProducto () {
            Integer esperado = 1;
            Integer actual = this.producto.getId();
            assertEquals(esperado, actual);

            assertTrue(this.producto.getId() == this.igual.getIdCategoria());
            assertTrue(this.producto.getId() != this.distinto.getIdCategoria());
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
        public void getIdCategoria () {
            Integer esperado = 1;
            Integer actual = this.producto.getIdCategoria();
            assertEquals(esperado, actual);

            assertTrue(this.producto.getIdCategoria() == this.igual.getIdCategoria());
            assertTrue(this.producto.getIdCategoria() != this.distinto.getIdCategoria());
        }

        @Test
        public void equals() {
            assertTrue(this.producto.equals(this.igual));
            assertTrue(!this.producto.equals(this.distinto));
        }

    @Test
    public void test () {
        int id_esperado = 1;
        int id_actual = this.producto.getId();
        String nombre_esperado = "anana";
        String nombre_actual = this.producto.getNombre();
        int cat_esperada = 1;
        int cat_actual = this.producto.getIdCategoria();

        assertEquals(id_esperado, id_actual);
        assertEquals(nombre_esperado, nombre_actual);
        assertEquals(cat_esperada, cat_actual);

        String str_esperado = "1 anana 1";
        String str_actual = this.producto.toString();
        assertEquals(str_esperado, str_actual);

        id_esperado = 0;
        id_actual = this.vacio.getId();
        nombre_esperado = "";
        nombre_actual = this.vacio.getNombre();
        cat_esperada = 0;
        cat_actual = this.vacio.getIdCategoria();

        assertEquals(id_esperado, id_actual);
        assertEquals(nombre_esperado, nombre_actual);
        assertEquals(cat_esperada, cat_actual);
    }

}