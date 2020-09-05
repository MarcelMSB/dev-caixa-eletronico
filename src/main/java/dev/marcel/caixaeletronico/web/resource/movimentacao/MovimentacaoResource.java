package dev.marcel.caixaeletronico.web.resource.movimentacao;

import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.marcel.caixaeletronico.model.movimentacao.Movimentacao;
import dev.marcel.caixaeletronico.model.movimentacao.MovimentacaoLimitadaService;
import dev.marcel.caixaeletronico.model.movimentacao.MovimentacaoLivreService;

import dev.marcel.caixaeletronico.web.dto.movimentacao.MovimentacaoDto;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MovimentacaoResource {

    @Inject
    private MovimentacaoLivreService serviceLivre;
    @Inject
    private MovimentacaoLimitadaService serviceLimitada;

    @Inject
    private MovimentacaoDto.RepresentationBuilder builder;

    @POST
    @Path("livres/{valor}")
    public Response movimentacaoLivre(@PathParam("valor") Long valor) {
        final Movimentacao movimentacao = serviceLivre.getMovimentacao(valor);
        return Response.accepted(builder.toRepresentation(movimentacao)).build();
    }

    @POST
    @Path("limitadas/{valor}")
    public Response movimentacaoLimitada(@PathParam("valor") Long valor) {
        final Movimentacao movimentacao = serviceLimitada.getMovimentacao(valor);
        return Response.accepted(builder.toRepresentation(movimentacao)).build();
    }
}
