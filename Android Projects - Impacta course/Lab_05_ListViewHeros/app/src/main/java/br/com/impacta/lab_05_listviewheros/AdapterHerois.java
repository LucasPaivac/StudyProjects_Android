package br.com.impacta.lab_05_listviewheros;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class AdapterHerois extends BaseAdapter {

    private Context context;
    private int resource;
    private List<HMAux> dados;

    private LayoutInflater nInflater;

    private int contador = 0;

    private long idselecionado = -1L;

    public void setIdselecionado(long idselecionado) {
        //this.idselecionado = idselecionado;
        if (idselecionado != this.idselecionado) {
            this.idselecionado = idselecionado;
        } else {
            this.idselecionado = -1;
        }
        //
        notifyDataSetChanged(); // refresh
    }

    public AdapterHerois(Context context, int resource, List<HMAux> dados) {
        this.context = context;
        this.resource = resource;
        this.dados = dados;

        this.nInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Devolve a quantidade de registros na minha coleção
    @Override
    public int getCount() {
        return dados.size();
    }

    // Devolve um registro especifico da minha coleção referenciada pelo paramentro position
    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    // Devolve o ID do registro da posiçao referenciada pelo parametro position
    @Override
    public long getItemId(int position) {
        HMAux item = dados.get(position);

        return Long.parseLong(item.get(Constantes.ID));
    }

    // Responsável por criar a celula (Juntar dados com o Layout da celula)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        boolean bNew = false;

        if (convertView == null) {
            bNew = true;
            contador++;

            convertView = nInflater.inflate(resource, parent, false);
        }

        //Acesso aos Dados de uma posição especifica
        HMAux item = dados.get(position);

        //Acesso aos Campos da celula
        LinearLayout ll_fundo = convertView.findViewById(R.id.celula_ll_fundo);

        ImageView iv_imagem = convertView.findViewById(R.id.celula_iv_imagem);

        TextView tv_nome = convertView.findViewById(R.id.celula_tv_nome);
        TextView tv_contador = convertView.findViewById(R.id.celula_tv_contador);

        //Movmentando os dados para dentro do layout
        iv_imagem.setImageResource(Integer.parseInt(item.get(Constantes.IMAGEM)));
        tv_nome.setText(item.get(Constantes.NOME));

        if (bNew) {
            tv_contador.setText(String.valueOf(contador));
        }

        //Regra de negócio

        if (item.get(Constantes.DISPONIBILIDADE).equals("0")) {
            tv_nome.setTextColor(context.getColor(R.color.vermelho));
        } else {
            tv_nome.setTextColor(context.getColor(R.color.padrao));
        }

        if (getItemId(position) == idselecionado) {
            ll_fundo.setBackgroundColor(context.getColor(R.color.item_selecionado));
        } else {
            ll_fundo.setBackgroundColor(context.getColor(R.color.item_nao_selecionado));
        }

        return convertView;
    }
}
