package br.com.udemystudy.udemy_06_atmempresa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private ImageView iv_empresa;
    private ImageView iv_servico;
    private ImageView iv_cliente;
    private ImageView iv_contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        iv_empresa = findViewById(R.id.iv_empresa);
        iv_servico = findViewById(R.id.iv_servico);
        iv_cliente = findViewById(R.id.iv_cliente);
        iv_contato = findViewById(R.id.iv_contato);

    }

    private void inicializarAcoes() {

        iv_empresa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, EmpresaActivity.class));
            }
        });

        iv_servico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ServicoActivity.class));
            }
        });

        iv_cliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ClienteActivity.class));
            }
        });

        iv_contato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, ContatoActivity.class));
            }
        });
    }

}
