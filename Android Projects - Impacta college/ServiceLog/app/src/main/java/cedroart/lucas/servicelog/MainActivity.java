package cedroart.lucas.servicelog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_mensagem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        btn_mensagem = (Button) findViewById(R.id.btn_mensagem);
        btn_mensagem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), DelayMessageService.class);
                intent.putExtra(DelayMessageService.EXTRA_MESSAGE,getResources().getString(R.string.mensagem));
                startService(intent);
            }
        });

    }
}
