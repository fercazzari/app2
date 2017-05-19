package pp2.app2.modelo.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by fcazzari on 19/05/2017.
 */
public class MercadoPagoTest {

    MercadoPago mercadoPago;
    String esperado, actual;

    @Before
    public void setUp() throws Exception {
        this.mercadoPago = new MercadoPago("Visa");
    }

    @Test
    public void test() {
        actual = this.mercadoPago.toString();
        esperado = "MercadoPago";
        assertEquals(esperado, actual);
    }

}