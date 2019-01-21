package br.com.udemystudy.udemy_12_series;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private SeekBar sb_escala;

    private ImageView iv_status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        sb_escala = findViewById(R.id.sb_escala);
        iv_status = findViewById(R.id.iv_status);

    }

    private void inicializarAcoes() {

        sb_escala.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                switch (progress) {
                    case 1:
                        iv_status.setImageResource(R.drawable.pouco);
                        break;

                    case 2:
                        iv_status.setImageResource(R.drawable.medio);
                        break;

                    case 3:
                        iv_status.setImageResource(R.drawable.muito);
                        break;

                    case 4:
                        iv_status.setImageResource(R.drawable.susto);
                        break;

                    default:
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
