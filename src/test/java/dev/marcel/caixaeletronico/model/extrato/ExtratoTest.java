package dev.marcel.caixaeletronico.model.extrato;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import dev.marcel.caixaeletronico.common.util.Pagination;
import dev.marcel.caixaeletronico.model.cedula.Cedula;
import dev.marcel.caixaeletronico.model.movimentacao.Movimentacao;

@RunWith(CdiRunner.class)
public class ExtratoTest {

    @Inject
    private Extrato extrato;

    @Test
    public void extratoNaoPaginadoTest() {
        assertEquals("Size tem que ser zero", extrato.getMovimentacoes().size(), 0);
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
        extrato.addMovimentacoes(movimentacao);
        assertEquals("Size tem que ser um", extrato.getMovimentacoes().size(), 1);
    }
    
    @Test
    public void extratoPaginadoTest() {
        assertEquals("Size tem que ser um", extrato.getMovimentacoes().size(), 1);
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
        for(int i = 0; i < 6; i++){
            extrato.addMovimentacoes(movimentacao);
        }
        assertEquals("Size tem que ser sete", extrato.getMovimentacoes().size(), 7);
        
        Pagination pagination = extrato.getMovimentacoes(1, 2);
        assertEquals("Total tem que ser sete", pagination.getTotal(), 7);
        assertEquals("Size do content tem que ser 1", pagination.getContent().size(), 1);
        
    }
}
