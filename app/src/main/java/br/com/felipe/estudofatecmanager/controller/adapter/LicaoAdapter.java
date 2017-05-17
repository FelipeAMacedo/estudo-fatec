package br.com.felipe.estudofatecmanager.controller.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.felipe.estudofatecmanager.R;
import br.com.felipe.estudofatecmanager.model.Conteudo;
import br.com.felipe.estudofatecmanager.model.Licao;
import br.com.felipe.estudofatecmanager.view.ViewHolder.LicaoViewHolder;

/**
 * Created by felip on 14/05/2017.
 */

public class LicaoAdapter extends RecyclerView.Adapter {

    private List<Licao> lista;
    private Context ctx;

    public LicaoAdapter(List<Licao> lista, Context ctx) {
        this.lista = lista;
        this.ctx = ctx;
    }

    public Licao getItem(int position) {
        return lista.get(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.rv_licoes, parent, false);

        LicaoViewHolder lvHolder = new LicaoViewHolder(view);
        return lvHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        LicaoViewHolder lvHolder = (LicaoViewHolder) holder;

        Licao licao = lista.get(position);

        lvHolder.getTvNomeLicao().setText(licao.getTitulo());

        int nQuestoes = 0;

        if(licao.getListaConteudo() != null) {
            for (Conteudo c : licao.getListaConteudo()) {
                if (c.getQuestao() != null) {
                    nQuestoes++;
                }
            }
        }

        StringBuilder sb = new StringBuilder("")
                .append(nQuestoes)
                .append(" Quest");

        if(nQuestoes == 1) {
            sb.append("ão");
        } else {
            sb.append("ões");
        }

        lvHolder.getTvNQuestoes().setText(sb.toString());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}
