package br.com.felipe.estudofatecmanager.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.estudofatecmanager.R;
import br.com.felipe.estudofatecmanager.controller.adapter.UnidadeAdapter;
import br.com.felipe.estudofatecmanager.controller.dao.MateriaDAO;
import br.com.felipe.estudofatecmanager.controller.dao.UnidadeDAO;
import br.com.felipe.estudofatecmanager.controller.listener.firebase.UnidadeEventListener;
import br.com.felipe.estudofatecmanager.model.Materia;
import br.com.felipe.estudofatecmanager.model.Unidade;

public class AddMateriaActivity extends AppCompatActivity {

    private ListView lvUnidades;
    private Button btnNovaUnidade;
    private UnidadeAdapter unidadesAdapter;
    private List<Unidade> listaUnidades = new ArrayList<>();
    private Button btnSalvarMateria;
    private EditText etNomeMateria;

    private Materia materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_materia);
        initComponentes();
        initListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();

        populateList();
    }

    private void initComponentes() {
        lvUnidades       =  (ListView)       findViewById(R.id.lvUnidades);
        btnNovaUnidade   =  (Button)         findViewById(R.id.btnNovaUnidade);
        btnSalvarMateria =  (Button)         findViewById(R.id.btnSalvarMateria);
        etNomeMateria    =  (EditText)       findViewById(R.id.etNomeMateria);
        materia          =  initMateria();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        etNomeMateria.setText(materia.getTitulo());


        unidadesAdapter = new UnidadeAdapter(listaUnidades, AddMateriaActivity.this);
        lvUnidades.setAdapter(unidadesAdapter);
    }

    private void initListeners() {
        btnNovaUnidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddMateriaActivity.this, AddUnidadeActivity.class);
                startActivityForResult(i, 1);
            }
        });

        btnSalvarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materia.setTitulo(etNomeMateria.getText().toString());

                //materia.getListaUnidades().get(i).getListaLicao().get(u).getListaConteudo().get(2).getQuestao().getListaResposta();

                List<Unidade> unidades = materia.getListaUnidades();

                materia.setListaUnidades(null);

                if(materia.getKey() == null) {
                    materia.setKey(new MateriaDAO().insert(materia));

//                 TODO : Criar um condicional para fazer update das unidades e para inserir novas
                    for(Unidade u : unidades) {
                        new UnidadeDAO().insert(u, materia.getKey());
                    }
                } else {
                    new MateriaDAO().update(materia);
                }

            }
        });

        lvUnidades.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Unidade u1 = unidadesAdapter.getItem(i);

                Intent intent = new Intent(AddMateriaActivity.this, AddUnidadeActivity.class);
                intent.putExtra("unidade", u1);
                startActivity(intent);
            }
        });
    }

    private Materia initMateria() {
        Materia m = (Materia) getIntent().getSerializableExtra("materia");

        if (m == null) {
            m = new Materia();
            m.setListaUnidades(new ArrayList<Unidade>());
        }

        return m;
    }

    private void populateList() {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("unidades/" + materia.getKey());
        dbRef.addValueEventListener(new UnidadeEventListener(listaUnidades, unidadesAdapter));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Unidade u = (Unidade) data.getSerializableExtra("unidade");

                materia.getListaUnidades().add(u);
                unidadesAdapter.notifyDataSetChanged();
            }
        }
    }
}
