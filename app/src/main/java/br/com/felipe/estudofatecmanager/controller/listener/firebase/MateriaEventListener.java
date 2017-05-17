package br.com.felipe.estudofatecmanager.controller.listener.firebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import br.com.felipe.estudofatecmanager.controller.adapter.MateriaAdapter;
import br.com.felipe.estudofatecmanager.model.Materia;

/**
 * Created by felip on 24/04/2017.
 */

public class MateriaEventListener implements ValueEventListener {

    private List<Materia> lista;
    private MateriaAdapter materiaAdapter;

    public MateriaEventListener(List<Materia> lista, MateriaAdapter materiaAdapter) {
        this.lista = lista;
        this.materiaAdapter = materiaAdapter;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();

        for(DataSnapshot d : dataSnapshot.getChildren()) {
            Materia m = d.getValue(Materia.class);
            m.setKey(d.getKey());
            lista.add(m);
        }

        materiaAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}

