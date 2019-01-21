package cedroart.lucas.penalti;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuActivity extends AppCompatActivity {
    private Button btn_jogar;
    private MediaPlayer som_trilha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);

        btn_jogar = (Button) findViewById(R.id.btn_jogar);
        som_trilha = MediaPlayer.create(getBaseContext(),R.raw.trilha);

        som_trilha.start();

        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), GamePlayActivity.class);
                startActivity(ir);
                ConfigGamePlay.CHUTES = 5;
                ConfigGamePlay.PLACARCOMPUTADOR = 0;
                ConfigGamePlay.PLACARJOGADOR = 0;
                ConfigGamePlay.ESCOLHAJOGADOR = 0;
            }
        });
    }
    protected void onPause() {
        super.onPause();
        som_trilha.pause();
    }
}
