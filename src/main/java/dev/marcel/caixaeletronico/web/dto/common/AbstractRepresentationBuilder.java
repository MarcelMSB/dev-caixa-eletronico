package dev.marcel.caixaeletronico.web.dto.common;

import java.util.ArrayList;
import java.util.List;

import dev.marcel.caixaeletronico.common.util.Pagination;

public abstract class AbstractRepresentationBuilder<T, DTO, B> {

    protected abstract T fromRepresentation(DTO dto, B builder);

    protected abstract DTO toRepresentation(T t);

    public List<DTO> toRepresentation(List<T> lista) {
        final List<DTO> listaDto = new ArrayList<>();
        lista.stream().forEach(registro -> {
            listaDto.add(this.toRepresentation(registro));
        });
        return listaDto;
    }
    
    public PaginationDto<DTO> toRepresentation(Pagination<T> pagination) {
        final List<DTO> listaDto = new ArrayList<>();
        pagination.getContent().stream().forEach(registro -> {
            listaDto.add(this.toRepresentation(registro));
        });
        return new PaginationDto<>(pagination.getLimit(), pagination.getOffset(), pagination.getTotal(),pagination.hasNext(), listaDto);
    }
}
