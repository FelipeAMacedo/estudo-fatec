package br.com.felipe.estudofatecmanager.model;

import java.io.Serializable;

/**
 * Created by felip on 21/04/2017.
 */

public class Conteudo implements Serializable {
    private String titulo;
    private String texto;
    private Questao questao;

    public Conteudo() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
