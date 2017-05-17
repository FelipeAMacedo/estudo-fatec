package br.com.felipe.estudofatecmanager.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by felip on 21/04/2017.
 */

public class Materia implements Serializable {
    private String key;
    private String titulo;
    private List<Unidade> listaUnidades;

    public Materia() {
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

    public List<Unidade> getListaUnidades() {
        return listaUnidades;
    }

    public void setListaUnidades(List<Unidade> listaUnidades) {
        this.listaUnidades = listaUnidades;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
