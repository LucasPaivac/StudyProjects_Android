package cedroart.lucas.jokenpo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static cedroart.lucas.jokenpo.R.drawable.papel;

public class GamePlayActivity extends AppCompatActivity {
    private ImageView iv_player;
    private ImageView iv_pc;
    private Button btn_pedra;
    private Button btn_papel;
    private Button btn_tesoura;
    private TextView tv_placar_jogador;
    private TextView tv_placar_computador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_game_play);

        iv_player = (ImageView) findViewById(R.id.iv_player);
        iv_pc = (ImageView) findViewById(R.id.iv_pc);
        btn_pedra = (Button) findViewById(R.id.btn_pedra);
        btn_papel = (Button) findViewById(R.id.btn_papel);
        btn_tesoura = (Button) findViewById(R.id.btn_tesoura);
        tv_placar_jogador = (TextView) findViewById(R.id.tv_placar_jogador);
        tv_placar_computador = (TextView) findViewById(R.id.tv_placar_computador);


        btn_pedra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_player.setImageResource(R.drawable.pedra);
                Computador();
                ConfigGamePlay.ESCOLHAJOGADOR= 1;
                Verifica();

            }
        });
        btn_papel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_player.setImageResource(papel);
                Computador();
                ConfigGamePlay.ESCOLHAJOGADOR= 2;
                Verifica();

            }
        });
        btn_tesoura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_player.setImageResource(R.drawable.tesoura);
                Computador();
                ConfigGamePlay.ESCOLHAJOGADOR= 3;
                Verifica();

            }
        });
    }
        public void Computador (){
            int escolha = (int) (Math.random()*3)+1;
            if(escolha == 1){
                iv_pc.setImageResource(R.drawable.pedra);
                ConfigGamePlay.ESCOLHACOMPUTADOR = 1;
            }else if(escolha == 2) {
                iv_pc.setImageResource(R.drawable.papel);
                ConfigGamePlay.ESCOLHACOMPUTADOR = 2;
            }else if(escolha == 3) {
                iv_pc.setImageResource(R.drawable.tesoura);
                ConfigGamePlay.ESCOLHACOMPUTADOR = 3;
            }
    }

    public void Verifica(){
        if(     ConfigGamePlay.ESCOLHAJOGADOR == 1 & ConfigGamePlay.ESCOLHACOMPUTADOR == 2 ||
                ConfigGamePlay.ESCOLHAJOGADOR == 2 & ConfigGamePlay.ESCOLHACOMPUTADOR == 3 ||
                ConfigGamePlay.ESCOLHAJOGADOR == 3 & ConfigGamePlay.ESCOLHACOMPUTADOR == 1){
                    ConfigGamePlay.PLACARCOMPUTADOR += 1;
        }else if(ConfigGamePlay.ESCOLHAJOGADOR == 1 & ConfigGamePlay.ESCOLHACOMPUTADOR == 3 ||
                 ConfigGamePlay.ESCOLHAJOGADOR == 2 & ConfigGamePlay.ESCOLHACOMPUTADOR == 1 ||
                 ConfigGamePlay.ESCOLHAJOGADOR == 3 & ConfigGamePlay.ESCOLHACOMPUTADOR == 2){
                    ConfigGamePlay.PLACARJOGADOR += 1;
        }else{}
        tv_placar_jogador.setText(Integer.toString(ConfigGamePlay.PLACARJOGADOR));
        tv_placar_computador.setText(Integer.toString(ConfigGamePlay.PLACARCOMPUTADOR));

        if(ConfigGamePlay.PLACARJOGADOR == 5){
            Intent ir = new Intent(getBaseContext(), VitoriaActivity.class);
            startActivity(ir);
        }else if(ConfigGamePlay.PLACARCOMPUTADOR == 5){
            Intent ir2 = new Intent(getBaseContext(), DerrotaActivity.class);
            startActivity(ir2);
        }
    }
}


