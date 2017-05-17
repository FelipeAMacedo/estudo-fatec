package br.com.felipe.estudofatecmanager.controller.listener.firebase;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import br.com.felipe.estudofatecmanager.controller.adapter.MateriaAdapter;
import br.com.felipe.estudofatecmanager.controller.adapter.UnidadeAdapter;
import br.com.felipe.estudofatecmanager.model.Materia;
import br.com.felipe.estudofatecmanager.model.Unidade;

/**
 * Created by felip on 13/05/2017.
 */

public class UnidadeEventListener implements ValueEventListener {

    private List<Unidade> lista;
    private UnidadeAdapter unidadeAdapter;

    public UnidadeEventListener(List<Unidade> lista, UnidadeAdapter unidadeAdapter) {
        this.lista = lista;
        this.unidadeAdapter = unidadeAdapter;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();

        for(DataSnapshot d : dataSnapshot.getChildren()) {
            Unidade u = d.getValue(Unidade.class);
            u.setKey(d.getKey());
            lista.add(u);
        }

        unidadeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
