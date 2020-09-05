package dev.marcel.caixaeletronico.model.movimentacao;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import dev.marcel.caixaeletronico.model.cedula.Cedula;


@RequestScoped
public class MovimentacaoLimitadaService extends AbstractMovimentacaoService {

    @Override
    public boolean usaLimitesCedulas() {
        return true;
    }

    @Override
    public Map<Cedula, Long> getLimitesCedulas() {
        final Map<Cedula, Long> cedulas = new HashMap<>();
        cedulas.put(Cedula.CEM, 5L);
        cedulas.put(Cedula.CINQUENTA, 10L);
        cedulas.put(Cedula.VINTE, 15L);
        cedulas.put(Cedula.DEZ, 20L);
        return cedulas; 
    }
    
    
}
