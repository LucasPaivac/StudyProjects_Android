package br.com.impacta.lab_05_comidas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_comidas;
    private ArrayList<HMAux> comidas;

    private AdapterComidas adapterComidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {
        context = MainActivity.this;

        lv_comidas = findViewById(R.id.lv_comidas);

        gerarComidas();

        adapterComidas = new AdapterComidas(context, R.layout.celula, comidas);

        lv_comidas.setAdapter(adapterComidas);


    }

    private void gerarComidas() {
        comidas = new ArrayList<>();

        for (int i = 0; i < nomesDeComidas.length ; i++) {
            HMAux aux = new HMAux();
            aux.put(Constantes.ID, String.valueOf(i+1));
            aux.put(Constantes.COMIDA, nomesDeComidas[i]);
            aux.put(Constantes.CALORIA, infoCalorias[i] + " Kcal");
            aux.put(Constantes.SELECIONADO, "0");

            comidas.add(aux);
        }
    }

    String[] nomesDeComidas =
    {
        "Milho verde",
        "Pé de Moleque",
        "Arroz doce",
        "Paçoca",
        "Pipoca salgada",
        "Queijadinha",
        "Quentão",
        "Caldo verde",
        "Canjica",
        "Bolo de fubá",
        "Pamonha"
    };

    String[] infoCalorias =
    {
        "132",
        "87",
        "65",
        "114",
        "89",
        "209",
        "294",
        "79",
        "113",
        "263",
        "127"
    };

    private void inicializarAcoes() {

        lv_comidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                adapterComidas.atualizaStatus(position);
            }
        });

    }
}
