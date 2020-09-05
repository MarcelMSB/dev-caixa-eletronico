package dev.marcel.caixaeletronico.model.movimentacao.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.FIELD;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Stereotype;

@Stereotype
@RequestScoped
@Retention(RUNTIME)
@Target({ METHOD, FIELD, TYPE })
public @interface MovimentacaoService {

    public String value();
}
