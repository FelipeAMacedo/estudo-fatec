package br.com.felipe.estudofatecmanager.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by felip on 21/04/2017.
 */

public class Licao implements Serializable {
    private String key;
    private String titulo;
    private List<Conteudo> listaConteudo;

    public Licao() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Conteudo> getListaConteudo() {
        return listaConteudo;
    }

    public void setListaConteudo(List<Conteudo> listaConteudo) {
        this.listaConteudo = listaConteudo;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
