package br.com.impacta.lab_06_soma;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity_A extends AppCompatActivity {

    public static final int PROCESSO_SOMA = 10;

    private Context context;

    private EditText et_vx;
    private EditText et_vy;

    private Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = Activity_A.this;

        et_vx = findViewById(R.id.activity_a_et_vx);
        et_vy = findViewById(R.id.activity_a_et_vy);

        btn_enviar = findViewById(R.id.activity_a_btn_enviar);

    }

    private void inicializarAcoes() {

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(context, Activity_B.class);


                mIntent.putExtra(Constantes.X, Integer.parseInt(et_vx.getText().toString()));
                mIntent.putExtra(Constantes.Y, Integer.parseInt(et_vy.getText().toString()));

                startActivityForResult(mIntent, PROCESSO_SOMA);
                //startActivity(mIntent);

            }
        });

    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode)
        {
            case PROCESSO_SOMA:
                processarSoma(resultCode, data);
                break;
            default:
                //log
                break;
        }
    }

    private void processarSoma(int resultCode, Intent data) {

        String resultado = null;

        if (resultCode == RESULT_OK)
        {
            resultado = "Resultado: " + String.valueOf(data.getIntExtra(Constantes.RETORNO, -1));
        }else
            {
                resultado = "Resultado: Operação cancelada.";
            }

        Toast.makeText(context, resultado, Toast.LENGTH_SHORT).show();

    }

}
