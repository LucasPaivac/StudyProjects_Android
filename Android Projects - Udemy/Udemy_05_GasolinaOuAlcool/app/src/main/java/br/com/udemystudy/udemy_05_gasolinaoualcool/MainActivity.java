package br.com.udemystudy.udemy_05_gasolinaoualcool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_alcool;
    private EditText et_gasolina;

    private Button btn_verificar;

    private TextView tv_resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        et_alcool = findViewById(R.id.et_alcool);
        et_gasolina = findViewById(R.id.et_gasolina);
        btn_verificar = findViewById(R.id.btn_verificar);
        tv_resultado = findViewById(R.id.tv_resultado);
    }

    private void inicializarAcoes() {

        btn_verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String alcool = et_alcool.getText().toString();
                String gasolina = et_gasolina.getText().toString();

                if (!alcool.isEmpty() && !gasolina.isEmpty())
                {
                    Double valorAlcool = Double.parseDouble(alcool);
                    Double valorGasolina = Double.parseDouble(gasolina);

                    double resultado = valorAlcool/valorGasolina;

                    if (resultado >= 0.7)
                    {
                        tv_resultado.setText("Ultilize a gasolina !");
                    }
                    else
                    {
                        tv_resultado.setText("Ultilize o alcool !");
                    }
                }else
                    {
                        tv_resultado.setText("Preencha o valor da gasolina e do alcool!");
                    }

            }
        });
    }
}
