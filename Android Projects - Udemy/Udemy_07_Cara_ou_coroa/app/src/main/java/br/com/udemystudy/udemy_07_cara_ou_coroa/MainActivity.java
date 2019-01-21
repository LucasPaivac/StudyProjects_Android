package br.com.udemystudy.udemy_07_cara_ou_coroa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ImageView iv_jogar;
    private String[] opcao = {"Cara", "Coroa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        iv_jogar = findViewById(R.id.iv_jogar);
    }

    private void inicializarAcoes() {

        iv_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int numeroAleatorio = random.nextInt(2);

                Intent detalhe = new Intent(context, DetalheActivity.class);
                detalhe.putExtra("opcao", opcao[numeroAleatorio]);

                startActivity(detalhe);
            }
        });

    }
}
