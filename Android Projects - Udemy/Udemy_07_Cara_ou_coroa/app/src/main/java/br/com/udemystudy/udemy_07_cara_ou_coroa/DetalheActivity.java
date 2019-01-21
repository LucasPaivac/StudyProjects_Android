package br.com.udemystudy.udemy_07_cara_ou_coroa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DetalheActivity extends AppCompatActivity {

    private Context context;
    private ImageView iv_moeda;
    private ImageView iv_voltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_detalhe);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = DetalheActivity.this;

        iv_moeda = findViewById(R.id.iv_moeda);
        iv_voltar = findViewById(R.id.iv_voltar);
    }

    private void inicializarAcoes() {

        Bundle extra = getIntent().getExtras();

        if (extra != null)
        {
            String opcaoEscolhida = extra.getString("opcao");
            if (opcaoEscolhida.equals("Cara"))
            {
                iv_moeda.setImageResource(R.drawable.moeda_cara);
            }else
                {
                    iv_moeda.setImageResource(R.drawable.moeda_coroa);
                }
        }

        iv_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                //startActivity(new Intent(context, MainActivity.class));
            }
        });
    }
}
