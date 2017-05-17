package br.com.felipe.estudofatecmanager.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by felip on 21/04/2017.
 */

public class Questao implements Serializable {
    private String pergunta;
    private List<Resposta> listaResposta;

    public Questao() {
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<Resposta> getListaResposta() {
        return listaResposta;
    }

    public void setListaResposta(List<Resposta> listaResposta) {
        this.listaResposta = listaResposta;
    }
}
