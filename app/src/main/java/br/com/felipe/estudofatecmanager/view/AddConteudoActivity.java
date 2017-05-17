package br.com.felipe.estudofatecmanager.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.felipe.estudofatecmanager.R;
import br.com.felipe.estudofatecmanager.model.Conteudo;

public class AddConteudoActivity extends AppCompatActivity {

    private EditText etNomeConteudo;
    private EditText etConteudo;
    private Button btnSalvarConteudo;
    private Conteudo conteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_conteudo);

        initComponents();
        initListeners();
    }

    private void initComponents() {
        etNomeConteudo = (EditText) findViewById(R.id.etNomeConteudo);
        etConteudo = (EditText) findViewById(R.id.etConteudo);
        btnSalvarConteudo = (Button) findViewById(R.id.btnSalvarConteudo);

        conteudo = new Conteudo();
    }

    private void initListeners() {
        btnSalvarConteudo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();

                conteudo.setTitulo(etNomeConteudo.getText().toString());
                conteudo.setTexto(etConteudo.getText().toString());

                i.putExtra("conteudo", conteudo);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}
