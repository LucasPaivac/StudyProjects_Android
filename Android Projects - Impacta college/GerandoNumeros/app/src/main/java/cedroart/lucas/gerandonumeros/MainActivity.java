package cedroart.lucas.gerandonumeros;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv_numero;
    private TextView btn_gerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        tv_numero = (TextView) findViewById(R.id.tv_numero);
        btn_gerar = (Button) findViewById(R.id.btn_gerar);

        btn_gerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = (int) (Math.random()*10)+1;/*Gerando número de 01 a 10, devido inserir o +1*/
                tv_numero.setText(String.valueOf(numero));
            }
        });
    }
}
