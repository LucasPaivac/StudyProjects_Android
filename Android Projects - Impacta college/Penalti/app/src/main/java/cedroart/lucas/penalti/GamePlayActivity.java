package cedroart.lucas.penalti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class GamePlayActivity extends AppCompatActivity {
    private TextView tv_gols;
    private TextView tv_defesas;
    private TextView tv_chutes;
    private ImageButton imb_bola1;
    private ImageButton imb_bola2;
    private ImageButton imb_bola3;
    private ImageButton imb_bola4;
    private ImageButton imb_bola5;
    private ImageButton imb_bola6;
    private ImageButton imb_bola7;
    private ImageButton imb_bola8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_gameplay);

        tv_gols = (TextView) findViewById(R.id.tv_gols);
        tv_defesas = (TextView) findViewById(R.id.tv_defesas);
        tv_chutes = (TextView) findViewById(R.id.tv_chutes);
        imb_bola1 = (ImageButton) findViewById(R.id.imb_bola1);
        imb_bola2 = (ImageButton) findViewById(R.id.imb_bola2);
        imb_bola3 = (ImageButton) findViewById(R.id.imb_bola3);
        imb_bola4 = (ImageButton) findViewById(R.id.imb_bola4);
        imb_bola5 = (ImageButton) findViewById(R.id.imb_bola5);
        imb_bola6 = (ImageButton) findViewById(R.id.imb_bola6);
        imb_bola7 = (ImageButton) findViewById(R.id.imb_bola7);
        imb_bola8 = (ImageButton) findViewById(R.id.imb_bola8);


        imb_bola1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGamePlay.ESCOLHAJOGADOR= (int) ((Math.random()*2)+1);
                Verifica();
                Vitoriaouderrota();
            }
        });
        imb_bola2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGamePlay.ESCOLHAJOGADOR= (int) ((Math.random()*2)+1);
                Verifica();
                Vitoriaouderrota();
            }
        });
        imb_bola3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGamePlay.ESCOLHAJOGADOR= (int) ((Math.random()*2)+1);
                Verifica();
                Vitoriaouderrota();
            }
        });
        imb_bola4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGamePlay.ESCOLHAJOGADOR= (int) ((Math.random()*2)+1);
                Verifica();
                Vitoriaouderrota();
            }
        });
        imb_bola5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGamePlay.ESCOLHAJOGADOR= (int) ((Math.random()*2)+1);
                Verifica();
                Vitoriaouderrota();
            }
        });
        imb_bola6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGamePlay.ESCOLHAJOGADOR= (int) ((Math.random()*2)+1);
                Verifica();
                Vitoriaouderrota();
            }
        });
        imb_bola7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGamePlay.ESCOLHAJOGADOR= (int) ((Math.random()*2)+1);
                Verifica();
                Vitoriaouderrota();
            }
        });
        imb_bola8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGamePlay.ESCOLHAJOGADOR= (int) ((Math.random()*2)+1);
                Verifica();
                Vitoriaouderrota();
            }
        });

    }

    public void Verifica (){
        if (ConfigGamePlay.ESCOLHAJOGADOR == 1){
            ConfigGamePlay.PLACARJOGADOR += 1;
            ConfigGamePlay.CHUTES -= 1;
        }else if (ConfigGamePlay.ESCOLHAJOGADOR == 2){
            ConfigGamePlay.PLACARCOMPUTADOR +=1;
            ConfigGamePlay.CHUTES -= 1;
        }else{}
        tv_gols.setText(Integer.toString(ConfigGamePlay.PLACARJOGADOR));
        tv_defesas.setText(Integer.toString(ConfigGamePlay.PLACARCOMPUTADOR));
        tv_chutes.setText(Integer.toString(ConfigGamePlay.CHUTES));
    }
    public void Vitoriaouderrota () {
        if (ConfigGamePlay.CHUTES == 0 && ConfigGamePlay.PLACARJOGADOR > ConfigGamePlay.PLACARCOMPUTADOR){
            Intent ir = new Intent(getBaseContext(), VitoriaActivity.class);
            startActivity(ir);
        }else if (ConfigGamePlay.CHUTES == 0 && ConfigGamePlay.PLACARJOGADOR < ConfigGamePlay.PLACARCOMPUTADOR){
            Intent ir = new Intent(getBaseContext(), DerrotaActivity.class);
            startActivity(ir);
        }
    }
}
