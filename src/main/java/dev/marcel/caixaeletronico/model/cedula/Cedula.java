package dev.marcel.caixaeletronico.model.cedula;

public enum Cedula {

    CEM(100L, "100,00"),
    CINQUENTA(50L, "50,00"),
    VINTE(20L, "20,00"),
    DEZ(10L, "10,00");

    public final Long value;
    public final String descricao;

    private Cedula(Long value, String descricao) {
        this.value = value;
        this.descricao = descricao;
    }

    public Long getValue() {
        return value;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean lessThanEqual(Long valor) {
        return valor >= value;
    }

    public Long getValorByNumeroCedula(Long valor) {
        return value * valor;
    }
}
