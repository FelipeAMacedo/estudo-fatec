package br.com.felipe.estudofatecmanager.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.felipe.estudofatecmanager.R;
import br.com.felipe.estudofatecmanager.model.Conteudo;
import br.com.felipe.estudofatecmanager.model.Licao;

public class AddLicaoActivity extends AppCompatActivity {

    private EditText etNomeLicao;
    private Button btnNovoConteudo;
    private Button btnSalvarLicao;
    private ListView lvConteudos;
    private ArrayAdapter<Conteudo> conteudosAdapter;
    private Licao licao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_licao);
        initComponents();
        initListeners();
    }

    private void initComponents() {
        etNomeLicao     = (EditText) findViewById(R.id.etNomeLicao);
        btnNovoConteudo = (Button)   findViewById(R.id.btnNovoConteudo);
        btnSalvarLicao  = (Button)   findViewById(R.id.btnSalvarLicao);
        lvConteudos     = (ListView) findViewById(R.id.lvConteudos);

        licao = initLicao();

        etNomeLicao.setText(licao.getTitulo());

//        conteudosAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, licao.getListaConteudo());
//        lvConteudos.setAdapter(conteudosAdapter);

    }

    private Licao initLicao() {
        Licao l = (Licao) getIntent().getSerializableExtra("licao");

        if (l == null) {
            l = new Licao();
            l.setListaConteudo(new ArrayList<Conteudo>());
        }

        return l;
    }

    private void initListeners() {
        btnNovoConteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddLicaoActivity.this, AddConteudoActivity.class);
                startActivityForResult(i, 1);
            }
        });

        btnSalvarLicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();

                licao.setTitulo(etNomeLicao.getText().toString());

                i.putExtra("licao", licao);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                Conteudo c = (Conteudo) data.getSerializableExtra("conteudo");

                licao.getListaConteudo().add(c);
                conteudosAdapter.notifyDataSetChanged();
            }
        }
    }
}
