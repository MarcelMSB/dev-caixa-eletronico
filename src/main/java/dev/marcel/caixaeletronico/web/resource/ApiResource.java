package dev.marcel.caixaeletronico.web.resource;

import javax.inject.Inject;
import javax.ws.rs.Path;

import dev.marcel.caixaeletronico.web.resource.extrato.ExtratoResource;
import dev.marcel.caixaeletronico.web.resource.movimentacao.MovimentacaoResource;

@Path("api")
public class ApiResource {

    @Inject
    private MovimentacaoResource movimentacaoResource;
    @Inject
    private ExtratoResource extratoResource;

    @Path("movimentacoes")
    public MovimentacaoResource movimentacao() {
        return movimentacaoResource;
    }

    @Path("extratos")
    public ExtratoResource estrato() {
        return extratoResource;
    }
}
