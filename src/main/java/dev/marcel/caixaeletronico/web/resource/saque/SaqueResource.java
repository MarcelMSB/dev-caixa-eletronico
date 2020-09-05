package dev.marcel.caixaeletronico.web.resource.saque;


import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.marcel.caixaeletronico.model.movimentacao.Extrato;
import dev.marcel.caixaeletronico.model.movimentacao.Movimentacao;
import dev.marcel.caixaeletronico.model.movimentacao.MovimentacaoLimitadaService;
import dev.marcel.caixaeletronico.model.movimentacao.MovimentacaoService;

import dev.marcel.caixaeletronico.web.dto.movimentacao.MovimentacaoDto;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SaqueResource {

    @Inject
    private MovimentacaoService service;
    @Inject
    private MovimentacaoLimitadaService serviceLimitado;
    @Inject
    private Extrato extrato;
    @Inject
    private MovimentacaoDto.RepresentationBuilder builder;

    @POST
    @Path("{valor}")
    public Response saque(@PathParam("valor") Long valor) {
        final Movimentacao movimentacao = service.getMovimentacao(valor);
        extrato.addMovimentacoes(movimentacao);
        return Response.accepted(builder.toRepresentation(movimentacao)).build();
    }

    @POST
    @Path("limitados/{valor}")
    public Response saqueLimitado(@PathParam("valor") Long valor) {
        final Movimentacao movimentacao = serviceLimitado.getMovimentacao(valor);
        extrato.addMovimentacoes(movimentacao);
        return Response.accepted(builder.toRepresentation(movimentacao)).build();
    }
}
