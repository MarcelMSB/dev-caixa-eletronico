package dev.marcel.caixaeletronico.model.movimentacao;

import java.time.LocalDateTime;
import java.util.Map;

import dev.marcel.caixaeletronico.model.cedula.Cedula;

public class Movimentacao {

    public LocalDateTime dataHora;
    public Long valor;
    public Map<Cedula, Long> cedulas;

    protected Movimentacao() {
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

    public static class Builder {

        private final Movimentacao novimentacao;

        private Builder(final Movimentacao novimentacao) {
            this.novimentacao = novimentacao;
        }

        public static Builder create() {
            return new Builder(new Movimentacao());
        }

        public Builder dataHora(final LocalDateTime dataHora) {
            novimentacao.dataHora = dataHora;
            return this;
        }

        public Builder valor(Long valor) {
            novimentacao.valor = valor;
            return this;
        }

        public Builder cedulas(Map<Cedula, Long> cedulas) {
            novimentacao.cedulas = cedulas;
            return this;
        }

        public Movimentacao build() {
            return novimentacao;
        }
    }
}
