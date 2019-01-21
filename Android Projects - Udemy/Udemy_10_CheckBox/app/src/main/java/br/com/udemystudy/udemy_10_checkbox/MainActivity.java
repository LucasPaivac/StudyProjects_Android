package br.com.udemystudy.udemy_10_checkbox;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private CheckBox cb_cachorro;
    private CheckBox cb_gato;
    private CheckBox cb_papagaio;

    private Button btn_resultado;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        cb_cachorro = findViewById(R.id.cb_cachorro);
        cb_gato = findViewById(R.id.cb_gato);
        cb_papagaio = findViewById(R.id.cb_papagaio);

        btn_resultado = findViewById(R.id.btn_resultado);
        tv_resultado = findViewById(R.id.tv_resultado);

    }

    private void inicializarAcoes() {

        btn_resultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tv_resultado.setText(
                        cb_cachorro.getText() + ": " + cb_cachorro.isChecked() + "\n" +
                        cb_gato.getText() + ": " + cb_gato.isChecked() + "\n" +
                        cb_papagaio.getText() + ": " + cb_papagaio.isChecked()
                );
            }
        });

    }
}
