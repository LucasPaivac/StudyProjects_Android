package cedroart.lucas.musica;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private Button btn_jogarnovamente;
    private TextView tv_acerto;
    private TextView tv_acertos;
    private ImageView iv_logo;
    private int TEMPO = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_resultado);

        btn_jogarnovamente = (Button) findViewById(R.id.btn_jogarnovamente);
        tv_acertos = (TextView) findViewById(R.id.tv_acertos);
        iv_logo = (ImageView) findViewById(R.id.iv_logo);
        tv_acerto = (TextView) findViewById(R.id.tv_acerto);

        tv_acertos.setText(Integer.toString(ConfigGameplay.correto));


        btn_jogarnovamente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigGameplay.correto = 0;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent ir = new Intent(getBaseContext(), FaseAActivity.class);
                        startActivity(ir);
                    }
                },TEMPO);

            }
        });

    }
}
