package pp2.app2.modelo.domain;

import org.junit.Before;
import org.junit.Test;

import pp2.app2.modelo.app.DatosTemp;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 19/05/2017.
 */
public class RecomendadorTest {

    DatosTemp datosTemp;
    Recomendador recomendador;
    Producto producto, actual, esperado;

    @Before
    public void setUp () {
        this.datosTemp = new DatosTemp();
        this.recomendador = new Recomendador();
        this.recomendador.agregarSugerencia(datosTemp.obtenerProducto(101), datosTemp.obtenerProducto(102));
        this.producto = datosTemp.obtenerProducto(101);
    }

    @Test
    public void test() {
        actual = this.recomendador.recomendar(this.producto);
        esperado = datosTemp.obtenerProducto(102);

        assertEquals(actual, esperado);
    }

}