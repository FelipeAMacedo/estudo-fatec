package br.com.felipe.estudofatecmanager.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.estudofatecmanager.R;
import br.com.felipe.estudofatecmanager.controller.adapter.MateriaAdapter;
import br.com.felipe.estudofatecmanager.controller.listener.firebase.MateriaEventListener;
import br.com.felipe.estudofatecmanager.model.Materia;

public class MainActivity extends AppCompatActivity {

    private ListView lvMaterias;
    private Button btnNovaMateria;
//    private ArrayAdapter<Materia> materiasAdapter;
    private MateriaAdapter materiasAdapter;
    private List<Materia> listaMaterias = new ArrayList<>();
    private Button btnAtualizarLista;
//    private LinearLayout llMaterias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        initListeners();
    }

    @Override
    protected void onResume(){
        super.onResume();

        populateList();
    }

    private void initComponents() {
        btnNovaMateria = (Button) findViewById(R.id.btnNovaMateria);
        btnAtualizarLista = (Button) findViewById(R.id.btnAtualizarLista);

        lvMaterias = (ListView) findViewById(R.id.lvMaterias);

        materiasAdapter = new MateriaAdapter(listaMaterias, MainActivity.this);
        lvMaterias.setAdapter(materiasAdapter);
    }

    private void initListeners() {
        btnNovaMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AddMateriaActivity.class);
                startActivity(i);
            }
        });

        btnAtualizarLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                populateList();
            }
        });

        lvMaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Materia m1 = (Materia) materiasAdapter.getItem(i);

                Intent intent = new Intent(MainActivity.this, AddMateriaActivity.class);
                intent.putExtra("materia", m1);
                startActivity(intent);

            }
        });
    }

    private void populateList() {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("materias");
        dbRef.addValueEventListener(new MateriaEventListener(listaMaterias, materiasAdapter));
    }
}
