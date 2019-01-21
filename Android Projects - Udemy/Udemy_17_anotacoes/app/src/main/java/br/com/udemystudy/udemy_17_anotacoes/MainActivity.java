package br.com.udemystudy.udemy_17_anotacoes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_anotacoes;

    private ImageView iv_salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        et_anotacoes = findViewById(R.id.et_anotacoes);

        iv_salvar = findViewById(R.id.iv_salvar);

    }

    private void inicializarAcoes() {
        iv_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDigitado = et_anotacoes.getText().toString();
                gravarNoArquivo(textoDigitado);


            }
        });

        if (lerArquivo() != null)
        {
            et_anotacoes.setText(lerArquivo());
        }
    }

    private void gravarNoArquivo(String texto) {

        try {

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(Constantes.ANOTACAOTXT, context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();

            Toast.makeText(context, "Anotação salva com sucesso", Toast.LENGTH_SHORT).show();

        }catch (IOException e)
        {
            Log.v("MainActivity", e.toString());
        }
    }

    private String lerArquivo()
    {
        String resultado = "";

        try {
            InputStream arquivo = openFileInput(Constantes.ANOTACAOTXT);
            if (arquivo != null)
            {
                //Ler o arquivo
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);

                //Gerar buffer do arquivo lido
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                //Recuperar textos do arquivo
                String linhaArquivo = "";
                while ((linhaArquivo = bufferedReader.readLine()) != null)
                {
                    resultado += linhaArquivo;
                }

                arquivo.close();
            }
        }catch (IOException e)
        {
            Log.v("MainActivity", e.toString());
        }

        return resultado;
    }
}
