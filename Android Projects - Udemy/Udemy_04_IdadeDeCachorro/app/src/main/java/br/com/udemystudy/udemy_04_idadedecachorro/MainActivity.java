package br.com.udemystudy.udemy_04_idadedecachorro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_idade;
    private Button btn_descobrir;
    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        et_idade = findViewById(R.id.et_idade);
        btn_descobrir = findViewById(R.id.btn_descobrir);
        tv_resultado = findViewById(R.id.tv_resultado);
    }

    private void inicializarAcoes() {
        btn_descobrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idade = et_idade.getText().toString();

                if (idade.isEmpty())
                {
                    tv_resultado.setText("Digite a idade do seu cachorro!");
                    et_idade.requestFocus();
                }else
                    {
                        int idadeDigitada = Integer.parseInt(idade);
                        int resultado = idadeDigitada * 7;
                        tv_resultado.setText("Seu cachorro tem " + resultado + " anos humanos");
                    }
            }
        });
    }
}
