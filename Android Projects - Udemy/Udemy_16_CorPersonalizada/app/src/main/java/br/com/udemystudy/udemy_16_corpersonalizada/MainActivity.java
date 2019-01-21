package br.com.udemystudy.udemy_16_corpersonalizada;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private LinearLayout ll_fundo;

    private RadioGroup rg_cores;
    private RadioButton rb_selecionado;

    private Button btn_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        ll_fundo = findViewById(R.id.ll_fundo);

        rg_cores = findViewById(R.id.rg_cores);

        btn_salvar = findViewById(R.id.btn_salvar);

    }

    private void inicializarAcoes() {

        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id_rb_selecionado = rg_cores.getCheckedRadioButtonId();

                if (id_rb_selecionado > 0)
                {
                    rb_selecionado = findViewById(id_rb_selecionado);

                    SharedPreferences sharedPreferences = getSharedPreferences(Constantes.PREFERENCIAL, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    String corEscolhida = rb_selecionado.getText().toString();
                    editor.putString(Constantes.COR, corEscolhida);
                    editor.commit();

                    setBackground(corEscolhida);

                }else
                {
                    Toast.makeText(context, "Selecione uma cor!", Toast.LENGTH_SHORT).show();
                }

            }

        });

        SharedPreferences sharedPreferences = getSharedPreferences(Constantes.PREFERENCIAL, 0);
        if (sharedPreferences.contains(Constantes.COR))
        {
            String cor = sharedPreferences.getString(Constantes.COR, "Branco");
            setBackground(cor);
        }
    }

    private void setBackground(String cor) {

        if (cor.equals("Azul"))
        {
            ll_fundo.setBackgroundColor(Color.parseColor("#2334CA"));
        }else if (cor.equals("Laranja"))
        {
            ll_fundo.setBackgroundColor(Color.parseColor("#f18432"));
        }else if (cor.equals("Verde"))
        {
            ll_fundo.setBackgroundColor(Color.parseColor("#4cb135"));
        }else if (cor.equals("Branco"))
        {
            ll_fundo.setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
    }


}
