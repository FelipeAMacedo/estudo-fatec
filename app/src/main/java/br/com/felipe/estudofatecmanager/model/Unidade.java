package br.com.felipe.estudofatecmanager.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by felip on 21/04/2017.
 */

public class Unidade implements Serializable {
    private String key;
    private String titulo;
    private List<Licao> listaLicao;

    public Unidade() {
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

    public List<Licao> getListaLicao() {
        return listaLicao;
    }

    public void setListaLicao(List<Licao> listaLicao) {
        this.listaLicao = listaLicao;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
