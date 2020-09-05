package dev.marcel.caixaeletronico.web.resource;

import javax.inject.Inject;
import javax.ws.rs.Path;

import dev.marcel.caixaeletronico.web.resource.extrato.ExtratoResource;
import dev.marcel.caixaeletronico.web.resource.saque.SaqueResource;

@Path("api")
public class ApiResource {

    @Inject
    private SaqueResource saqueResource;
    @Inject
    private ExtratoResource extratoResource;

    @Path("saques")
    public SaqueResource saque() {
        return saqueResource;
    }

    @Path("extratos")
    public ExtratoResource estrato() {
        return extratoResource;
    }
}
