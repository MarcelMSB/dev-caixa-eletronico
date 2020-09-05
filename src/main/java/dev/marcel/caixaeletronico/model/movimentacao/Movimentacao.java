package dev.marcel.caixaeletronico.model.movimentacao;

import java.time.LocalDateTime;
import java.util.Map;

import dev.marcel.caixaeletronico.model.cedula.Cedula;

public class Movimentacao {
    
    public static final String MOVIMENTACAO_SERVICE_DEFAULT = "MOVIMENTACAO_SERVICE_DEFAULT";
    public static final String MOVIMENTACAO_SERVICE_LIMITE = "MOVIMENTACAO_SERVICE_LIMITE";
    
    public final LocalDateTime dataHora;
    public final Long valor;
    public final Map<Cedula, Long> cedulas;

    public Movimentacao(LocalDateTime dataHora, Long valor, Map<Cedula, Long> cedulas) {
        this.dataHora = dataHora;
        this.valor = valor;
        this.cedulas = cedulas;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Long getValor() {
        return valor;
    }

    public Map<Cedula, Long> getCedulas() {
        return cedulas;
    }
}
