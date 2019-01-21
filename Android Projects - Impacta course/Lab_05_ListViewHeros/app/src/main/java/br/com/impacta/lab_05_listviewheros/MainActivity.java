package br.com.impacta.lab_05_listviewheros;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ListView lv_heros;
    private SimpleAdapter adapter_heros;
    private ArrayList<HMAux> heros;

    private AdapterHerois adapterHerois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {
        context = MainActivity.this;

        lv_heros = findViewById(R.id.lv_heros);

        gerarHeros(11);

        String[] De = {Constantes.IMAGEM, Constantes.NOME};
        int[] Para = {R.id.celula_iv_imagem, R.id.celula_tv_nome};

//        adapter_heros = new SimpleAdapter
//                (
//                        context,
//                        heros,
//                        R.layout.celula,
//                        De,
//                        Para
//                );

//        lv_heros.setAdapter(new AdapterHerois(context, R.layout.celula, heros));

        adapterHerois = new AdapterHerois(context, R.layout.celula, heros);

        lv_heros.setAdapter(adapterHerois);
    }

    private void gerarHeros(int quantidade) {
        heros = new ArrayList<>();

        for (int i = 0; i < imagens.length; i++) {
            HMAux aux = new HMAux();
            aux.put(Constantes.ID, String.valueOf(i+1));
            aux.put(Constantes.NOME, nomes[i]);
            aux.put(Constantes.IMAGEM, String.valueOf(imagens[i]));
            aux.put(Constantes.PODER, poderes[i]);
            aux.put(Constantes.DISPONIBILIDADE, disponibilidade[i]);

            heros.add(aux);

        }

    }

    //Geração fotos
    int imagens[] =
            {
                    R.drawable.avenger01,
                    R.drawable.avenger02,
                    R.drawable.avenger03,
                    R.drawable.avenger04,
                    R.drawable.avenger05,
                    R.drawable.avenger06,
                    R.drawable.avenger07,
                    R.drawable.avenger08,
                    R.drawable.avenger09,
                    R.drawable.avenger10,
                    R.drawable.avenger11

            };

    //Geração nomes
    String nomes[] =
            {
                    "Gavião Arqueiro",
                    "War Machine",
                    "Thor",
                    "Nick Fury",
                    "Loki",
                    "Iron Man",
                    "Hulk",
                    "Ant Man",
                    "Capitão América",
                    "Viúva Negra",
                    "Agente Calson"
            };

    //Geração poderes
    String poderes[] =
            {
                    "Flechas",
                    "Armadura",
                    "Trovão",
                    "Gerenciamento e Inteligência",
                    "Troll",
                    "Dinheiro",
                    "Força",
                    "Mudar de tamanho",
                    "Bom em luta",
                    "Bom em luta e persuadir",
                    "Inteligência"
            };

    String disponibilidade[] =
            {
                    "1",
                    "1",
                    "0",
                    "1",
                    "1",
                    "0",
                    "1",
                    "1",
                    "1",
                    "0",
                    "1"
            };

    private void inicializarAcoes() {

        lv_heros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HMAux item = (HMAux) parent.getItemAtPosition(position);

                adapterHerois.setIdselecionado(id);

                Toast.makeText(context, item.get(Constantes.PODER), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
