package br.com.udemystudy.udemy_03_frasedodia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_fdd;
    private TextView tv_frase;

    private String[] frases =
            {
                    "O importante não é vencer todos os dias, mas lutar sempre.",
                    "Maior que a tristeza de não haver vencido é a vergonha de não ter lutado!",
                    "É melhor conquistar a si mesmo do que vencer mil batalhas.",
                    "Enquanto houver vontade de lutar haverá esperança de vencer.",
                    "Para conseguir o que quer, você deve olhar além do que você vê."
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        btn_fdd = findViewById(R.id.btn_fdd);
        tv_frase = findViewById(R.id.tv_frase);
    }

    private void inicializarAcoes() {
        btn_fdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random random = new Random();
                int numeroAleatorio = random.nextInt(frases.length);

                tv_frase.setText(frases[numeroAleatorio]);
            }
        });
    }
}
