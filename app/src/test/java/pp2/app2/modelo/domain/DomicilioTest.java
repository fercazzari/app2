package pp2.app2.modelo.domain;

import org.junit.Before;
import org.junit.Test;

import pp2.app2.modelo.domain.Domicilio;

import static junit.framework.Assert.assertEquals;

/**
 * Created by fcazzari on 11/05/2017.
 */
public class DomicilioTest {

    Domicilio domicilio;
    String esperado, actual;

    @Test
    public void Domicilio () {
        this.domicilio = new Domicilio();
    }

    @Test
    public void test() {
        this.domicilio = new Domicilio("Calle 123");
        esperado = "Calle 123";
        actual = this.domicilio.getDatos();
        assertEquals(esperado, actual);
    }
}