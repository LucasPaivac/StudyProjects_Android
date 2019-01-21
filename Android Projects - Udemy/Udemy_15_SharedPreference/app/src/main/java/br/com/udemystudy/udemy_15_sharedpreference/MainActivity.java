package br.com.udemystudy.udemy_15_sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_nome;

    private Button btn_salvar;

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

        et_nome = findViewById(R.id.et_nome);

        btn_salvar = findViewById(R.id.btn_salvar);

        tv_resultado = findViewById(R.id.tv_resultado);
    }

    private void inicializarAcoes() {

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(Constantes.PREFERENCIAL, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String textoDigitado = et_nome.getText().toString();

                if (textoDigitado.equals("")) {
                    Toast.makeText(context, "Digite seu nome!", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString(Constantes.NOME, textoDigitado);
                    editor.commit();
                    tv_resultado.setText("Olá, " + textoDigitado);
                }
            }
        });

        //Recuperar dados salvos
        SharedPreferences sharedPreferences = getSharedPreferences(Constantes.PREFERENCIAL, 0);

        if (sharedPreferences.contains(Constantes.NOME))
        {
            String nomeUsuario = sharedPreferences.getString(Constantes.NOME, "Valor não encontrado.");
            tv_resultado.setText("Olá, " + nomeUsuario);
        }else
            {
                tv_resultado.setText("Olá, curso Android.");
            }
    }

}
