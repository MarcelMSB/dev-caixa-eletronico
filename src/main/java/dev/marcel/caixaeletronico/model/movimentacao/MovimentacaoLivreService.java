package dev.marcel.caixaeletronico.model.movimentacao;

import javax.enterprise.context.RequestScoped;


@RequestScoped
public class MovimentacaoLivreService extends AbstractMovimentacaoService{

    @Override
    public boolean usaLimitesCedulas() {
        return false;
    }
}
