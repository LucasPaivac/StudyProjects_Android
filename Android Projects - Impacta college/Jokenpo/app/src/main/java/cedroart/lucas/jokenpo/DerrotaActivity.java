package cedroart.lucas.jokenpo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class DerrotaActivity extends AppCompatActivity {
    private ImageButton imb_restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_derrota);

        imb_restart = (ImageButton) findViewById(R.id.imb_restart);

        imb_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                startActivity(ir);

            }
        });
    }
}
