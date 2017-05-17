package br.com.felipe.estudofatecmanager.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.felipe.estudofatecmanager.R;
import br.com.felipe.estudofatecmanager.controller.adapter.LicaoAdapter;
import br.com.felipe.estudofatecmanager.controller.dao.UnidadeDAO;
import br.com.felipe.estudofatecmanager.controller.listener.firebase.LicaoEventListener;
import br.com.felipe.estudofatecmanager.controller.listener.recycler.RecyclerItemClickListener;
import br.com.felipe.estudofatecmanager.model.Licao;
import br.com.felipe.estudofatecmanager.model.Unidade;

public class AddUnidadeActivity extends AppCompatActivity {

    private EditText etUnidade;
    private Button btnAdicionar;
    private Button btnNovaLicao;
    private RecyclerView rvLicoes;
    private List<Licao> listaLicoes = new ArrayList<>();
    private LicaoAdapter licaoAdapter;

    private Unidade unidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_unidade);

        initComponents();
        initListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();

        populateList();
    }

    private void initComponents() {
        etUnidade    = (EditText)     findViewById(R.id.etUnidade);
        btnAdicionar = (Button)       findViewById(R.id.btAdicionar);
        btnNovaLicao = (Button)       findViewById(R.id.btnNovaLicao);
        rvLicoes     = (RecyclerView) findViewById(R.id.rvLicoes);

        unidade = initUnidade();

        etUnidade.setText(unidade.getTitulo());

        licaoAdapter = new LicaoAdapter(listaLicoes, AddUnidadeActivity.this);
        rvLicoes.setAdapter(licaoAdapter);

        GridLayoutManager layout = new GridLayoutManager(AddUnidadeActivity.this, 2);
        rvLicoes.setLayoutManager(layout);
    }

    private void initListeners() {
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                unidade.setTitulo(etUnidade.getText().toString());//dd

                i.putExtra("unidade", unidade);

                if(unidade.getKey() != null) {
                    //new UnidadeDAO().insert(unidade);
                }

                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnNovaLicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddUnidadeActivity.this, AddLicaoActivity.class);
                startActivityForResult(i, 1);
            }
        });

        rvLicoes.addOnItemTouchListener(
                new RecyclerItemClickListener(AddUnidadeActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Licao l = licaoAdapter.getItem(position);

                        Intent intent = new Intent(AddUnidadeActivity.this, AddLicaoActivity.class);
                        intent.putExtra("licao", l);
                        startActivity(intent);
                    }
                })
        );
    }

    private Unidade initUnidade() {
        unidade = (Unidade) getIntent().getSerializableExtra("unidade");
//        unidade.getListaLicao().get(1).getListaConteudo().get(1).
        if (unidade == null) {
            unidade = new Unidade();
            unidade.setListaLicao(new ArrayList<Licao>());
        }

        return unidade;
    }

    private void populateList() {
        DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference("licoes/" + unidade.getKey());
        dbRef.addValueEventListener(new LicaoEventListener(listaLicoes, licaoAdapter));
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Licao l = (Licao) data.getSerializableExtra("licao");

                unidade.getListaLicao().add(l);
                licaoAdapter.notifyDataSetChanged();
            }
        }
    }
}
