package br.com.udemystudy.udemy_09_signos;

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

    private ListView lv_signos;

    private SignoAdapter signoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {
        context = MainActivity.this;

        lv_signos = findViewById(R.id.lv_signos);

        signoAdapter = new SignoAdapter(context, R.layout.celula, gerarSignos());

        lv_signos.setAdapter(signoAdapter);
    }

    private ArrayList<HMAux> gerarSignos() {

        ArrayList<HMAux> signos = new ArrayList<>();

        for (int i = 0; i < nomeSignos.length; i++) {
            HMAux aux = new HMAux();

            aux.put(Constantes.ID, String.valueOf(i+1));
            aux.put(Constantes.SIGNO, nomeSignos[i]);

            signos.add(aux);
        }

        return signos;
    }

    private void inicializarAcoes() {

        lv_signos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(context, mensagemSignos[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    String[] nomeSignos =
        {
            "Aquário",
            "Peixes",
            "Áries",
            "Touro",
            "Gêmeos",
            "Câncer",
            "Leão",
            "Virgem",
            "Libra",
            "Escorpião",
            "Sargitário",
            "Capricórnio",
        };

    String[] mensagemSignos =
            {
                    "Aquário: 20/01 à 18/02",
                    "Peixes: 19/02 à 20/03",
                    "Áries: 21/03 à 19/04",
                    "Touro: 20/04 à 20/05",
                    "Gêmeos: 21/05 à 20/06",
                    "Câncer: 21/06 à 22/07",
                    "Leão: 23/07 à 22/08",
                    "Virgem: 23/08 à 22/09",
                    "Libra: 23/09 à 22/10",
                    "Escorpião: 23/10 à 21/11",
                    "Sargitário: 22/11 à 21/12",
                    "Capricórnio: 22/12 à 19/01",
            };

}
