package dev.marcel.caixaeletronico.web.resource.extrato;

import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dev.marcel.caixaeletronico.model.movimentacao.Extrato;
import dev.marcel.caixaeletronico.web.dto.movimentacao.MovimentacaoDto;

@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ExtratoResource {

    @Inject
    private Extrato extrato;
    @Inject
    private MovimentacaoDto.RepresentationBuilder builder;

    @GET
    public Response movimentacoes() {
        return Response.accepted(builder.toRepresentation(extrato.getMovimentacoes())).build();
    }

    @GET
    @Path("paginado")
    public Response pageMovimentacoes(@QueryParam("limit") @DefaultValue("10") int limit, @QueryParam("offset") @DefaultValue("0") int offset) {
        return Response.accepted(builder.toRepresentation(extrato.getMovimentacoes(limit, offset))).build();
    }
}
