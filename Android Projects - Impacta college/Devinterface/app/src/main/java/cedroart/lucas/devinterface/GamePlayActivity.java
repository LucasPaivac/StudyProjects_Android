package cedroart.lucas.devinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GamePlayActivity extends AppCompatActivity {
    private TextView nivel;
    private Button voltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_5);

        nivel = (TextView) findViewById(R.id.tv_nivel);
        voltar = (Button) findViewById(R.id.btn_voltar);

        if(Configuracao.NIVEL == 1){
            nivel.setText("Nível: Easy");
        }else if (Configuracao.NIVEL == 2){
            nivel.setText("Nível: Medium");
        }else if (Configuracao.NIVEL == 3){
            nivel.setText("Nível: Hard");
        }else if (Configuracao.NIVEL == 4){
            nivel.setText("Nível: Insane");
        }
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Menu2Activity.class);
                startActivity(ir);
            }
        });
    }
}

