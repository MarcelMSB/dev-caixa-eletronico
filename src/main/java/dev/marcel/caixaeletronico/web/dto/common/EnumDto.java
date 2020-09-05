package dev.marcel.caixaeletronico.web.dto.common;

public class EnumDto {

    public final String value;
    public final String descricao;

    public EnumDto(String value, String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    public String getValue() {
        return value;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "{\"value\":" + value + ", \"descricao\":" + descricao + "\"}";
    }
}
