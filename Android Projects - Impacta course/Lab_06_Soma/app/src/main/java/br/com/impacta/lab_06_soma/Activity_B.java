package br.com.impacta.lab_06_soma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity_B extends AppCompatActivity {

    private Context context;

    private TextView tv_parametros;

    private Button btn_somar;

    private int x;
    private int y;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = Activity_B.this;

        tv_parametros = findViewById(R.id.activity_b_tv_parametros);

        btn_somar = findViewById(R.id.activity_b_btn_somar);

        recuperarParametros();

        tv_parametros.setText(String.valueOf(x) + " + " + String.valueOf(y));

    }

    private void recuperarParametros() {
        x = getIntent().getIntExtra(Constantes.X, -1);
        y = getIntent().getIntExtra(Constantes.Y, -1);
    }

    private void inicializarAcoes() {

        btn_somar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int total = y + x;

                Intent data = new Intent();

                    data.putExtra(Constantes.RETORNO, total);

                setResult(RESULT_OK, data);

                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
