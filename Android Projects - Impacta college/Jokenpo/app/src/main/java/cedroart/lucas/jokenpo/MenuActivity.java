package cedroart.lucas.jokenpo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {
    private ImageButton imb_jogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);

        imb_jogar = (ImageButton) findViewById(R.id.imb_jogar);

        imb_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), GamePlayActivity.class);
                startActivity(ir);
                ConfigGamePlay.PLACARJOGADOR = 0;
                ConfigGamePlay.ESCOLHAJOGADOR = 0;
                ConfigGamePlay.PLACARCOMPUTADOR = 0;
                ConfigGamePlay.ESCOLHACOMPUTADOR = 0;
            }
        });
    }
}
