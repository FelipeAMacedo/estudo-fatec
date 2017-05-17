package br.com.felipe.estudofatecmanager.controller.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.felipe.estudofatecmanager.R;
import br.com.felipe.estudofatecmanager.model.Materia;
import br.com.felipe.estudofatecmanager.model.Unidade;

/**
 * Created by felip on 13/05/2017.
 */

public class UnidadeAdapter extends BaseAdapter {
    private List<Unidade> lista;
    private Activity act;

    public UnidadeAdapter(List<Unidade> lista, Activity act) {
        this.lista = lista;
        this.act = act;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Unidade getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View v = act.getLayoutInflater().inflate(R.layout.lv_unidades_p, parent, false);
        Unidade u = lista.get(i);

        TextView tvTitulo = (TextView) v.findViewById(R.id.lv_unidades_p_nome);

        tvTitulo.setText(u.getTitulo());
        return v;
    }
}
