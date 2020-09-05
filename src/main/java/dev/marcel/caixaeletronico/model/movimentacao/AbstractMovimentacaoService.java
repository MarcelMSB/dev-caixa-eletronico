package dev.marcel.caixaeletronico.model.movimentacao;

import static dev.marcel.caixaeletronico.model.cedula.Cedula.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.ValidationException;

import dev.marcel.caixaeletronico.model.cedula.Cedula;
import dev.marcel.caixaeletronico.model.extrato.Extrato;

public abstract class AbstractMovimentacaoService {
    
    @Inject
    private Extrato extrato;
    
    public abstract boolean usaLimitesCedulas();

    public Map<Cedula, Long> getLimitesCedulas() {
        return new HashMap<>();
    }

    private Long getNumeroCedula(final Cedula cedula, final Long valor) {
        final Long numeroCedula = valor / cedula.getValue();
        if (usaLimitesCedulas()) {
            final Long limite = getLimitesCedulas().getOrDefault(cedula, 25L);
            if (numeroCedula > limite) {
                return limite;
            }
        }
        return numeroCedula;
    }

    public Movimentacao getMovimentacao(final Long valor) {
        if (0 != (valor % 10L)) {
            throw new ValidationException("São permitidas apenas movimentações de valores multiplos de 10!");
        }
        Long total = 0L;
        Map<Cedula, Long> cedulas = new HashMap<>();
        if (CEM.lessThanEqual(valor - total)) {
            final Long numeroCedula = getNumeroCedula(CEM, valor - total);
            total = total + CEM.getValorByNumeroCedula(numeroCedula);
            cedulas.put(CEM, numeroCedula);
        }
        if (CINQUENTA.lessThanEqual(valor - total)) {
            final Long numeroCedula = getNumeroCedula(CINQUENTA, valor - total);
            total = total + CINQUENTA.getValorByNumeroCedula(numeroCedula);
            cedulas.put(CINQUENTA, numeroCedula);
        }
        if (VINTE.lessThanEqual(valor - total)) {
            final Long numeroCedula = getNumeroCedula(VINTE, valor - total);
            total = total + VINTE.getValorByNumeroCedula(numeroCedula);
            cedulas.put(VINTE, numeroCedula);
        }
        if (DEZ.lessThanEqual(valor - total)) {
            final Long numeroCedula = getNumeroCedula(DEZ, valor - total);
            total = total + DEZ.getValorByNumeroCedula(numeroCedula);
            cedulas.put(DEZ, numeroCedula);
        }
        if (!valor.equals(total)) {
            throw new ValidationException("Devido ao limite do número de cédulas não foi possível realizar a movimentação!");
        }
        final Movimentacao movimentacao = Movimentacao.Builder.create()
                .dataHora(LocalDateTime.now())
                .valor(valor).cedulas(cedulas)
                .build();
        atualizaExtrato(movimentacao);
        return movimentacao;
    }
    
    private void atualizaExtrato(Movimentacao movimentacao){
        extrato.addMovimentacoes(movimentacao);
    }
}
