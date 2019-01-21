package cedroart.lucas.musica;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class FaseBActivity extends AppCompatActivity {
    private ImageButton imb_play;
    private ImageButton imb_pause;
    private Button btn_a;
    private Button btn_b;
    private Button btn_c;
    private Button btn_d;
    private static int TEMPO = 3000;

    private MediaPlayer santoespirito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_faseb);

        imb_play = (ImageButton) findViewById(R.id.imb_play);
        imb_pause = (ImageButton) findViewById(R.id.imb_pause);
        btn_a = (Button) findViewById(R.id.btn_a);
        btn_b = (Button) findViewById(R.id.btn_b);
        btn_c = (Button) findViewById(R.id.btn_c);
        btn_d = (Button) findViewById(R.id.btn_d);

        santoespirito = MediaPlayer.create(getBaseContext(),R.raw.playback_santo_espirito);

        imb_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                santoespirito.start();

            }
        });
        imb_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                santoespirito.pause();

            }
        });



        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desabilitar();
                onPause();
                Animation anim = new TranslateAnimation(0, 0, 0, -5);
                anim.setDuration(500);
                btn_a.startAnimation(anim);
                respota();
                Intent mandar = new Intent(getBaseContext(), ToastService.class);
                mandar.putExtra(ToastService.EXTRA_MESSAGE, getResources().getString(R.string.incorreto));
                startService(mandar);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent ir = new Intent(getBaseContext(), FaseCActivity.class);
                        startActivity(ir);
                    }
                },TEMPO);

            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desabilitar();
                onPause();
                Animation anim = new TranslateAnimation(0, 0, 0, -5);
                anim.setDuration(500);
                btn_b.startAnimation(anim);
                respota();
                Intent mandar = new Intent(getBaseContext(), ToastService.class);
                mandar.putExtra(ToastService.EXTRA_MESSAGE, getResources().getString(R.string.incorreto));
                startService(mandar);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent ir = new Intent(getBaseContext(), FaseCActivity.class);
                        startActivity(ir);
                    }
                },TEMPO);

            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desabilitar();
                onPause();
                Animation anim = new TranslateAnimation(0, 0, 0, -5);
                anim.setDuration(500);
                btn_c.startAnimation(anim);
                respota();
                Intent mandar = new Intent(getBaseContext(), ToastService.class);
                mandar.putExtra(ToastService.EXTRA_MESSAGE, getResources().getString(R.string.correto));
                startService(mandar);
                ConfigGameplay.correto +=1;

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent ir = new Intent(getBaseContext(), FaseCActivity.class);
                        startActivity(ir);
                    }
                },TEMPO);

            }
        });

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                desabilitar();
                onPause();
                Animation anim = new TranslateAnimation(0, 0, 0, -5);
                anim.setDuration(500);
                btn_d.startAnimation(anim);
                respota();
                Intent mandar = new Intent(getBaseContext(), ToastService.class);
                mandar.putExtra(ToastService.EXTRA_MESSAGE, getResources().getString(R.string.incorreto));
                startService(mandar);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent ir = new Intent(getBaseContext(), FaseCActivity.class);
                        startActivity(ir);
                    }
                },TEMPO);

            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        santoespirito.pause();
    }
    protected void respota() {
        btn_a.setTextColor(Color.parseColor("#FFC90F0F"));
        btn_b.setTextColor(Color.parseColor("#FFC90F0F"));
        btn_c.setTextColor(Color.parseColor("#FF189B2B"));
        btn_d.setTextColor(Color.parseColor("#FFC90F0F"));

    }

    protected void desabilitar() {
        btn_a.setEnabled(false);
        btn_b.setEnabled(false);
        btn_c.setEnabled(false);
        btn_d.setEnabled(false);
    }

}
