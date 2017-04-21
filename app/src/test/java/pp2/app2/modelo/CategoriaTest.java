package pp2.app2.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 09/04/2017.
 */
public class CategoriaTest {

    private Categoria categoria1;
    private Categoria categoria;

    @Before
    public void setUp() throws Exception {
        this.categoria1 = new Categoria();
        this.categoria = new Categoria(1, "Frutas");
    }

    @Test
    public void test () {

        int id_esperado = 1;
        int id_actual = this.categoria.getId();
        String nombre_esperado = "Frutas";
        String nombre_actual = this.categoria.getNombre();

        assertEquals(id_esperado, id_actual);
        assertEquals(nombre_esperado, nombre_actual);

        id_esperado = 0;
        id_actual = this.categoria1.getId();
        nombre_esperado = "";
        nombre_actual = this.categoria1.getNombre();

        assertEquals(id_esperado, id_actual);
        assertEquals(nombre_esperado, nombre_actual);

        String str_esperado = "1 Frutas";
        String str_actual = this.categoria.toString();
    }

}