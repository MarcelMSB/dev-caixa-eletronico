package dev.marcel.caixaeletronico.model.extrato;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.marcel.caixaeletronico.common.util.Pagination;
import dev.marcel.caixaeletronico.model.movimentacao.Movimentacao;

@ApplicationScoped
public class Extrato {

    public static List<Movimentacao> movimentacoes = new ArrayList<>();

    public List<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    public void addMovimentacoes(Movimentacao movimentacao) {
        movimentacoes.add(movimentacao);
    }

    public Pagination<Movimentacao> getMovimentacoes(int limit, int offset) {
        return new Pagination<>(limit, offset, movimentacoes.size(), movimentacoes.stream().skip(offset).limit(limit).collect(toList()));
    }
}
