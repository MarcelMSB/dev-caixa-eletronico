package dev.marcel.caixaeletronico.web.dto.movimentacao;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import dev.marcel.caixaeletronico.model.movimentacao.Movimentacao;
import dev.marcel.caixaeletronico.web.dto.common.AbstractDtoBuilder;
import dev.marcel.caixaeletronico.web.dto.common.AbstractRepresentationBuilder;
import dev.marcel.caixaeletronico.web.dto.common.EnumDto;

public class MovimentacaoDto {

    public LocalDateTime dataHora;
    public Long valor;
    public Map<EnumDto, Long> cedulas;

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Long getValor() {
        return valor;
    }

    public Map<EnumDto, Long> getCedulas() {
        return cedulas;
    }

    public static class Builder extends AbstractDtoBuilder<MovimentacaoDto> {

        private Builder(final MovimentacaoDto dto) {
            super(dto);
        }

        public static Builder create() {
            return new Builder(new MovimentacaoDto());
        }

        public Builder dataHora(final LocalDateTime dataHora) {
            dto.dataHora = dataHora;
            return this;
        }

        public Builder valor(Long valor) {
            dto.valor = valor;
            return this;
        }

        public Builder cedulas(Map<EnumDto, Long> cedulas) {
            dto.cedulas = cedulas;
            return this;
        }
    }

    public static class RepresentationBuilder extends AbstractRepresentationBuilder<Movimentacao, MovimentacaoDto, Object> {

        @Override
        public MovimentacaoDto toRepresentation(Movimentacao entity) {
            final Map<EnumDto, Long> cedulas = new HashMap<>();
            entity.getCedulas().entrySet()
                    .forEach(value -> cedulas.put(new EnumDto(value.getKey().name(), value.getKey().getDescricao()), value.getValue()));
            return MovimentacaoDto.Builder.create()
                    .dataHora(entity.getDataHora())
                    .valor(entity.getValor())
                    .cedulas(cedulas)
                    .build();
        }

        @Override
        protected Movimentacao fromRepresentation(MovimentacaoDto dto, Object builder) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
