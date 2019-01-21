package cedroart.lucas.devinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Menu2Activity extends AppCompatActivity {
    private ImageButton easy;
    private ImageButton medium;
    private ImageButton hard;
    private ImageButton insane;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_4);

        easy = (ImageButton) findViewById(R.id.ibtn_easy);
        medium = (ImageButton) findViewById(R.id.ibtn_medium);
        hard = (ImageButton) findViewById(R.id.ibtn_hard);
        insane = (ImageButton) findViewById(R.id.ibtn_insane);

        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuracao.NIVEL = 1;
                Configuracao.NIVEL1 = 1;
                Intent ir = new Intent(getBaseContext(), GamePlayActivity.class); /* Criação de objeto, pegar contexto, e ir para outra classe */
                startActivity(ir); /* Iniciando o objeto criado acima */
            }
        });

        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuracao.NIVEL = 2;
                Configuracao.NIVEL2 = 1;
                Intent ir = new Intent(getBaseContext(), GamePlayActivity.class); /* Criação de objeto, pegar contexto, e ir para outra classe */
                startActivity(ir); /* Iniciando o objeto criado acima */
            }
        });

        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuracao.NIVEL = 3;
                Configuracao.NIVEL3 = 1;
                Intent ir = new Intent(getBaseContext(), GamePlayActivity.class); /* Criação de objeto, pegar contexto, e ir para outra classe */
                startActivity(ir); /* Iniciando o objeto criado acima */
            }
        });

        insane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Configuracao.NIVEL1 == 1 && Configuracao.NIVEL2 == 1 && Configuracao.NIVEL3 == 1){
                    Configuracao.NIVEL = 4;
                    Intent ir = new Intent(getBaseContext(), GamePlayActivity.class); /* Criação de objeto, pegar contexto, e ir para outra classe */
                    startActivity(ir); /* Iniciando o objeto criado acima */
                }else {
                    Toast.makeText(getBaseContext(),"Nível BLoqueado", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
