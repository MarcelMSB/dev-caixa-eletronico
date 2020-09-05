package dev.marcel.caixaeletronico.model.movimentacao;

import dev.marcel.caixaeletronico.model.cedula.*;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
public class MovimentacaoTest {

    @Test
    public void buildTest() {
        final LocalDateTime dataHora = LocalDateTime.now();
        final Long valor = 1000L;
        final Map<Cedula, Long> cedulas = new HashMap<>();
        cedulas.put(Cedula.CEM, 5L);
        cedulas.put(Cedula.CINQUENTA, 10L);
        cedulas.put(Cedula.VINTE, 15L);
        cedulas.put(Cedula.DEZ, 20L);
        
        final Movimentacao movimentacao = Movimentacao.Builder.create()
                .dataHora(dataHora)
                .valor(valor)
                .cedulas(cedulas)
                .build();

        assertEquals("DataHora", dataHora, movimentacao.getDataHora());
        assertEquals("Valor", (long) valor, (long) movimentacao.getValor());
        assertEquals("Cedulas", cedulas.size(), movimentacao.getCedulas().size());
    }
}
