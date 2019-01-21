package br.com.udemystudy.udemy_13_radiobutton;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private RadioGroup rg_comidas;

    private RadioButton rb_escolhido;

    private Button btn_escolher;

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

        rg_comidas = findViewById(R.id.rg_comidas);

        btn_escolher = findViewById(R.id.btn_escolher);

        tv_resultado = findViewById(R.id.tv_resultado);
    }

    private void inicializarAcoes() {

        btn_escolher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id_rb_escolhido = rg_comidas.getCheckedRadioButtonId();

                if (id_rb_escolhido > 0)
                {
                    rb_escolhido = (RadioButton) findViewById(id_rb_escolhido);
                    tv_resultado.setText(rb_escolhido.getText());
                }else
                    {
                        Toast.makeText(context, "Escolha uma opção!", Toast.LENGTH_SHORT).show();
                    }
            }
        });

    }
}
