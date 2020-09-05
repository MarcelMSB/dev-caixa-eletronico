package dev.marcel.caixaeletronico.model.movimentacao;

import javax.enterprise.context.Dependent;

@Dependent
public class MovimentacaoLivreService extends AbstractMovimentacaoService{

    @Override
    public boolean usaLimitesCedulas() {
        return false;
    }
}
