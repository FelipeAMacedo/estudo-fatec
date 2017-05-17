package br.com.felipe.estudofatecmanager.controller.listener.firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import br.com.felipe.estudofatecmanager.controller.adapter.LicaoAdapter;
import br.com.felipe.estudofatecmanager.controller.adapter.MateriaAdapter;
import br.com.felipe.estudofatecmanager.model.Licao;
import br.com.felipe.estudofatecmanager.model.Materia;

/**
 * Created by felip on 14/05/2017.
 */

public class LicaoEventListener implements ValueEventListener {

    private List<Licao> lista;
    private LicaoAdapter licaoAdapter;

    public LicaoEventListener(List<Licao> lista, LicaoAdapter licaoAdapter) {
        this.lista = lista;
        this.licaoAdapter = licaoAdapter;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        lista.clear();

        for(DataSnapshot d : dataSnapshot.getChildren()) {
            Licao l = d.getValue(Licao.class);
            l.setKey(d.getKey());
            lista.add(l);
        }

        licaoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
