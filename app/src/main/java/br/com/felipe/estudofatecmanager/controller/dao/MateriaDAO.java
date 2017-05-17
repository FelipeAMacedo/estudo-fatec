package br.com.felipe.estudofatecmanager.controller.dao;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.estudofatecmanager.model.Materia;

/**
 * Created by felip on 22/04/2017.
 */

public class MateriaDAO {

    private DatabaseReference database;
    private List<Materia> materias = new ArrayList<>();

    public MateriaDAO() {
        database = FirebaseDatabase.getInstance().getReference("materias");
    }

    public List<Materia> getMaterias() {

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    Materia m = d.getValue(Materia.class);
                    materias.add(m);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return materias;
    }

    public String insert(Materia m) {
        m.setKey(database.push().getKey());
        update(m);

        return m.getKey();
    }

    public void update(Materia m) {
        database.child(m.getKey()).setValue(m);
    }
}
