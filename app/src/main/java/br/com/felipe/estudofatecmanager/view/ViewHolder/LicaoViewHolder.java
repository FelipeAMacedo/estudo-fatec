package br.com.felipe.estudofatecmanager.view.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.felipe.estudofatecmanager.R;

/**
 * Created by felip on 14/05/2017.
 */

public class LicaoViewHolder extends RecyclerView.ViewHolder {
    private TextView tvNomeLicao;
    private TextView tvNQuestoes;

    public LicaoViewHolder(View itemView) {
        super(itemView);

        tvNomeLicao = (TextView) itemView.findViewById(R.id.tvNomeLicao);
        tvNQuestoes = (TextView) itemView.findViewById(R.id.tvNQuestoes);
    }

    public TextView getTvNomeLicao() {
        return tvNomeLicao;
    }

    public void setTvNomeLicao(TextView tvNomeLicao) {
        this.tvNomeLicao = tvNomeLicao;
    }

    public TextView getTvNQuestoes() {
        return tvNQuestoes;
    }

    public void setTvNQuestoes(TextView tvNQuestoes) {
        this.tvNQuestoes = tvNQuestoes;
    }
}
