package br.com.udemystudy.udemy_08_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CidadeAdapter extends BaseAdapter {

    private Context context;
    private int resource;
    private ArrayList<HMAux> dados;

    private LayoutInflater mInflater;

    public CidadeAdapter(Context context, int resource, ArrayList<HMAux> dados) {
        this.context = context;
        this.resource = resource;
        this.dados = dados;

        this.mInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
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

        if (convertView == null)
        {
            convertView = mInflater.inflate(resource, parent, false);
        }

        HMAux item = dados.get(position);

        TextView tv_cidade = convertView.findViewById(R.id.celula_tv_ci);
        TextView tv_capital = convertView.findViewById(R.id.celula_tv_ca);

        tv_cidade.setText(item.get(Constantes.CIDADE));
        tv_capital.setText(item.get(Constantes.CAPITAL));

        return convertView;
    }
}
