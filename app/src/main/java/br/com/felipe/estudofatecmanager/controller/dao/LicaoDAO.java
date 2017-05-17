package br.com.felipe.estudofatecmanager.controller.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.estudofatecmanager.model.Licao;

import static android.R.attr.x;

/**
 * Created by felip on 23/04/2017.
 */

public class LicaoDAO {

    public List<Licao> getLicoes() {
        List<Licao> lista = new ArrayList<>();

        //Adicionar lição fictícia
        Licao l = new Licao();
        l.setTitulo("Básico 1");
        lista.add(l);

        return lista;
    }


    //TODO: Pegar a lista de lições de uma unidade no Firebase
}
