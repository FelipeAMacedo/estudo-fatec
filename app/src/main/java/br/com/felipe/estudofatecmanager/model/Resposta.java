package br.com.felipe.estudofatecmanager.model;

import java.io.Serializable;

/**
 * Created by felip on 21/04/2017.
 */

public class Resposta implements Serializable {
    private String texto;
    private boolean correta;

    public Resposta() {
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }
}
