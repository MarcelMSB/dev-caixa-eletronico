package dev.marcel.caixaeletronico.model.cedula;

import static dev.marcel.caixaeletronico.model.cedula.Cedula.CEM;
import static org.junit.Assert.*;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
public class CedulaTest {

    @Test
    public void lessThanEqualTest() {
        assertFalse("Menor que CEM", CEM.lessThanEqual(99L));
        assertTrue("Igual a CEM", CEM.lessThanEqual(100L));
        assertTrue("Maior que CEM", CEM.lessThanEqual(101L));
    }

    @Test
    public void getValorByNumeroCedulaTest() {
        assertEquals("Valor errado", (long) CEM.getValorByNumeroCedula(15L), 1500L);
    }
}
