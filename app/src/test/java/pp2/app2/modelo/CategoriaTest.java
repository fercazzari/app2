package pp2.app2.modelo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 09/04/2017.
 */
public class CategoriaTest {

    private Categoria categoria;

    @Before
    public void setUp() throws Exception {
        this.categoria = new Categoria(1, "Frutas");
    }

    @Test
    public void getNombre () {
        assertEquals(this.categoria.getNombre(), "Frutas");
    }

}