package br.com.impacta.lab_05_comidas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AdapterComidas extends BaseAdapter {

    private Context context;
    private int resource;
    private List<HMAux> dados;

    private LayoutInflater nInflater;

    private int contador = 0;

    public void atualizaStatus(int position){

        HMAux comida = dados.get(position);

        if (comida.get(Constantes.SELECIONADO).equals("1")){
            comida.put(Constantes.SELECIONADO, "0");
            contador--;
        } else {
            if (contador < 4){
                comida.put(Constantes.SELECIONADO, "1");
                contador++;
            } else {
                Toast.makeText(context, "Limite de seleção: 4", Toast.LENGTH_SHORT).show();
            }
        }
        //
        notifyDataSetChanged();
    }

    public AdapterComidas(Context context, int resource, List<HMAux> dados) {
        this.context = context;
        this.resource = resource;
        this.dados = dados;

        this.nInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dados.size();
    }

    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    @Override
    public long getItemId(int position) {
        HMAux item = dados.get(position);
        return Long.parseLong(item.get(Constantes.ID));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = nInflater.inflate(resource, parent, false);
        }

        HMAux item = dados.get(position);

        LinearLayout ll_fundo= convertView.findViewById(R.id.celula_ll_fundo);
        TextView tv_comida = convertView.findViewById(R.id.celula_tv_comida);
        TextView tv_caloria = convertView.findViewById(R.id.celula_tv_caloria);

        tv_comida.setText(item.get(Constantes.COMIDA));
        tv_caloria.setText(item.get(Constantes.CALORIA));

        if (item.get(Constantes.SELECIONADO).equals("0"))
        {
            ll_fundo.setBackgroundColor(context.getColor(R.color.item_nao_selecionado));
        }else
            {
                ll_fundo.setBackgroundColor(context.getColor(R.color.item_selecionado));
            }

        return convertView;
    }
}
