package br.com.felipe.estudofatecmanager.controller.dao;

import android.util.Log;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.estudofatecmanager.model.Unidade;

/**
 * Created by felip on 22/04/2017.
 */

public class UnidadeDAO {

    private DatabaseReference database;
    private String key;

    public UnidadeDAO() {
        database = FirebaseDatabase.getInstance().getReference("unidades");
    }

    public List<Unidade> getUnidades() {
        List<Unidade> lista = new ArrayList<Unidade>();
        Unidade u = new Unidade();

        //Faz a consulta no banco de dados e retorna

        return lista;
    }

    public List<Unidade> getUnidades(String materia) {
        List<Unidade> lista = new ArrayList<Unidade>();

        // TODO : Faz a consulta no banco de dados de acordo com o nome da materia

        return lista;
    }

    public String insert(Unidade u, String mKey) {
        key = "";
        database.child(mKey).push().setValue(u, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                key = databaseReference.getKey();
            }
        });

        return key;
    }

}
