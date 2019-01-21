package br.com.udemystudy.udemy_08_listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_cidades;

    private CidadeAdapter cidadeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        lv_cidades = findViewById(R.id.lv_cidades);

        cidadeAdapter = new CidadeAdapter(context, R.layout.celula, gerarCidades(50));

        lv_cidades.setAdapter(cidadeAdapter);

    }

    private ArrayList<HMAux> gerarCidades(int quantidade) {
        ArrayList<HMAux> cidades = new ArrayList<>();

        for (int i = 1; i <= quantidade ; i++) {
            HMAux aux = new HMAux();
            aux.put(Constantes.ID, String.valueOf(i));
            aux.put(Constantes.CIDADE, "Cidade - " + String.valueOf(i));
            aux.put(Constantes.CAPITAL, "Capital - " + String.valueOf(i));

            cidades.add(aux);
        }

        return cidades;
    }

    private void inicializarAcoes() {
    }
}
