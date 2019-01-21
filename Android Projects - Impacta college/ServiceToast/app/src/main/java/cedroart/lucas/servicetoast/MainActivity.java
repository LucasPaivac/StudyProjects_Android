package cedroart.lucas.servicetoast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        btn_toast = (Button) findViewById(R.id.btn_toast);
        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mandar = new Intent(getBaseContext(), ToastService.class);
                mandar.putExtra(ToastService.EXTRA_MESSAGE, getResources().getString(R.string.mensagem));
                startService(mandar);
            }
        });
    }
}
