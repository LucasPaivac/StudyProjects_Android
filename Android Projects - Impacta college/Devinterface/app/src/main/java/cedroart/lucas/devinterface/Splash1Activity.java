package cedroart.lucas.devinterface;

        import android.content.Intent;
        import android.os.Handler;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

public class Splash1Activity extends AppCompatActivity {
    public static int TEMPO = 4000; /* Criando variável */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_1); /* Fazendo link com o layout */

        new Handler().postDelayed(new Runnable() { /* Fazendo tela aparecer somente o tempo da variável */
            @Override
            public void run() {
                Intent ir = new Intent(getBaseContext(), Splash2Activity.class); /* Criação de objeto, pegar contexto, e ir para outra classe */
                startActivity(ir); /* Iniciando o objeto criado acima */
            }
        },TEMPO);
    }
}
