package cedroart.lucas.devinterface;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu1Activity extends AppCompatActivity {
    private ImageButton play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_3);

        play = (ImageButton) findViewById(R.id.ibtn_play);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), Menu2Activity.class); /* Criação de objeto, pegar contexto, e ir para outra classe */
                startActivity(ir); /* Iniciando o objeto criado acima */
            }
        });
    }
}
