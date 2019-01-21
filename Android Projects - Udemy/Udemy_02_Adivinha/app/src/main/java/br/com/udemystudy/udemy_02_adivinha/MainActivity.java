package br.com.udemystudy.udemy_02_adivinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn_jogar;
    private Button btn_limpar;

    private TextView tv_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        btn_jogar = findViewById(R.id.btn_jogar);
        btn_limpar = findViewById(R.id.btn_limpar);
        tv_num = findViewById(R.id.tv_num);

    }

    private void inicializarAcoes() {

        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomico = new Random();

                int numAleatorio = randomico.nextInt(10);
                tv_num.setText("Número escolhido: " + numAleatorio);
            }
        });

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LimparDados();
            }
        });
    }

    private void LimparDados() {
        tv_num.setText("Nenhum número");
    }
}
