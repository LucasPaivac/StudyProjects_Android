package cedroart.lucas.sonsandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_bird;
    private Button btn_dog;
    private Button btn_cat;
    private Button btn_pig;
    //sons
    private MediaPlayer som_bird;
    private MediaPlayer som_dog;
    private MediaPlayer som_cat;
    private MediaPlayer som_pig;
    private MediaPlayer som_trilha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        btn_bird = (Button) findViewById(R.id.btn_bird);
        btn_dog = (Button) findViewById(R.id.btn_dog);
        btn_cat = (Button) findViewById(R.id.btn_cat);
        btn_pig = (Button) findViewById(R.id.btn_pig);

        som_bird = MediaPlayer.create(getBaseContext(),R.raw.bird);
        som_dog = MediaPlayer.create(getBaseContext(),R.raw.dog2);
        som_cat = MediaPlayer.create(getBaseContext(),R.raw.cat);
        som_pig = MediaPlayer.create(getBaseContext(),R.raw.pig);
        som_trilha = MediaPlayer.create(getBaseContext(),R.raw.trilha);

        som_trilha.start();

        btn_bird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                som_bird.start();

            }
        });
        btn_dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                som_dog.start();

            }
        });
        btn_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                som_cat.start();

            }
        });
        btn_pig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                som_pig.start();

            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        som_trilha.pause();
    }
}
