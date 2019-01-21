package br.com.udemystudy.udemy_09_dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private Button btn_dialog;

    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        btn_dialog = findViewById(R.id.btn_dialog);
    }

    private void inicializarAcoes() {

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogConfig(dialog);
            }
        });

    }

    public void DialogConfig(AlertDialog.Builder dialog)
    {
        //Criando Alert Dialog
        dialog = new AlertDialog.Builder(context);

        dialog.setTitle("Titulo dialog");  //Configurando Titulo

        dialog.setMessage("Mensagem");  //Configurando mensagem

        dialog.setCancelable(false);
        dialog.setIcon(android.R.drawable.star_on);

        //Configurando botão não
        dialog.setNegativeButton(
                "Não",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Negativo", Toast.LENGTH_SHORT).show();
                    }
                });

        //Configurando botão sim
        dialog.setPositiveButton(
                "Sim",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Positivo", Toast.LENGTH_SHORT).show();
                    }
                });

        dialog.create();
        dialog.show();
    }
}
