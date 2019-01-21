package cedroart.lucas.movimentacao;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity  {
    private ImageView iv_spaceship;
    private Button btn_up;
    private Button btn_left;
    private Button btn_right;
    private Button btn_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        iv_spaceship = (ImageView) findViewById(R.id.iv_spaceship);
        btn_up = (Button) findViewById(R.id.btn_up);
        btn_left = (Button) findViewById(R.id.btn_left);
        btn_right = (Button) findViewById(R.id.btn_right);
        btn_down = (Button) findViewById(R.id.btn_down);

        btn_up.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                for (int i = 1; i > 0; i++) {
                    iv_spaceship.setY(iv_spaceship.getY() - 10);
                }

                return true;
            }
        });


    }

}
