package br.com.udemystudy.udemy_14_somdosbichos;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Context context;

    private ImageView iv_cao;
    private ImageView iv_gato;
    private ImageView iv_leao;
    private ImageView iv_macaco;
    private ImageView iv_ovelha;
    private ImageView iv_vaca;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {

        context = MainActivity.this;

        iv_cao = findViewById(R.id.iv_cao);
        iv_gato = findViewById(R.id.iv_gato);
        iv_leao = findViewById(R.id.iv_leao);
        iv_macaco = findViewById(R.id.iv_macaco);
        iv_ovelha = findViewById(R.id.iv_ovelha);
        iv_vaca = findViewById(R.id.iv_vaca);

    }

    private void inicializarAcoes() {

        iv_cao.setOnClickListener(this);
        iv_gato.setOnClickListener(this);
        iv_leao.setOnClickListener(this);
        iv_macaco.setOnClickListener(this);
        iv_ovelha.setOnClickListener(this);
        iv_vaca.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.iv_cao:
                mediaPlayer = MediaPlayer.create(context, R.raw.cao);
                tocarSom();
                break;
            case R.id.iv_gato:
                mediaPlayer = MediaPlayer.create(context, R.raw.gato);
                tocarSom();
                break;
            case R.id.iv_leao:
                mediaPlayer = MediaPlayer.create(context, R.raw.leao);
                tocarSom();
                break;
            case R.id.iv_macaco:
                mediaPlayer = MediaPlayer.create(context, R.raw.macaco);
                tocarSom();
                break;
            case R.id.iv_ovelha:
                mediaPlayer = MediaPlayer.create(context, R.raw.ovelha);
                tocarSom();
                break;
            case R.id.iv_vaca:
                mediaPlayer = MediaPlayer.create(context, R.raw.vaca);
                tocarSom();
                break;
            default:
                //Log
                break;
        }
    }

    private void tocarSom() {
        if (mediaPlayer != null)
        {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null)
        {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
