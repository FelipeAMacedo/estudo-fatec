package br.com.felipe.estudofatecmanager.controller.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.felipe.estudofatecmanager.R;
import br.com.felipe.estudofatecmanager.model.Materia;

/**
 * Created by felip on 07/05/2017.
 */

public class MateriaAdapter extends BaseAdapter {
    private List<Materia> lista;
    private Activity act;

    public MateriaAdapter(List<Materia> lista, Activity act) {
        this.lista = lista;
        this.act = act;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Materia getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View v = act.getLayoutInflater().inflate(R.layout.lv_materias_p, parent, false);
        Materia m = lista.get(i);

        TextView tvTitulo = (TextView) v.findViewById(R.id.lv_materias_p_nome);

        tvTitulo.setText(m.getTitulo());
        return v;
    }
}
