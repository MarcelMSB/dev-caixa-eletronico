package dev.marcel.caixaeletronico.model.movimentacao;

import static dev.marcel.caixaeletronico.model.movimentacao.Movimentacao.MOVIMENTACAO_SERVICE_DEFAULT;

import javax.enterprise.context.RequestScoped;

import dev.marcel.caixaeletronico.model.movimentacao.intf.IMovimentacaoService;

@RequestScoped
@dev.marcel.caixaeletronico.model.movimentacao.annotation.MovimentacaoService(MOVIMENTACAO_SERVICE_DEFAULT)
public class MovimentacaoService implements IMovimentacaoService{
    
}
