package dev.marcel.caixaeletronico.model.movimentacao;

import static dev.marcel.caixaeletronico.model.cedula.Cedula.*;
import static org.junit.Assert.assertEquals;

import dev.marcel.caixaeletronico.model.cedula.*;

import java.util.Map;

import javax.inject.Inject;
import javax.validation.ValidationException;

import org.jglue.cdiunit.CdiRunner;
import org.jglue.cdiunit.NgCdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(CdiRunner.class)
public class MovimentacaoServiceTest extends NgCdiRunner {

    @Inject
    private MovimentacaoLivreService serviceLivre;
    @Inject
    private MovimentacaoLimitadaService serviceLimitada;

    @Test
    public void movimentacaoLivreTest() {
        final Movimentacao movimentacao = serviceLivre.getMovimentacao(140L);

        assertEquals("Valor", (long) movimentacao.getValor(), 140L);
        assertEquals("Size de cedulas tem que ser 2", movimentacao.getCedulas().size(), 2);
        final Map<Cedula, Long> cedulas = movimentacao.getCedulas();
        assertEquals("Numero de cedulas de CEM deve ser 1", (long) cedulas.get(CEM), 1);
        assertEquals("Numero de cedulas de VINTE deve ser 2", (long) cedulas.get(VINTE), 2);
    }

    @Test(expected = ValidationException.class)
    public void movimentacaoLivreErrorTest() {
        serviceLivre.getMovimentacao(1L);
    }

    @Test
    public void movimentacaoLimitadaTest() {
        final Movimentacao movimentacao = serviceLimitada.getMovimentacao(620L);

        assertEquals("Valor", (long) movimentacao.getValor(), 620L);
        assertEquals("Size de cedulas tem que ser 3", movimentacao.getCedulas().size(), 3);
        final Map<Cedula, Long> cedulas = movimentacao.getCedulas();
        assertEquals("Numero de cedulas de CEM deve ser 1", (long) cedulas.get(CEM), 5);
        assertEquals("Numero de cedulas de CINQUENTA deve ser 2", (long) cedulas.get(CINQUENTA), 2);
        assertEquals("Numero de cedulas de VINTE deve ser 1", (long) cedulas.get(VINTE), 1);
    }

    @Test(expected = ValidationException.class)
    public void movimentacaoLimitadaErrorTest() {
        serviceLimitada.getMovimentacao(1L);
    }
    
    @Test(expected = ValidationException.class)
    public void movimentacaoLimitadaErrorLimiteTest() {
        serviceLimitada.getMovimentacao(100000L);
    }
}
