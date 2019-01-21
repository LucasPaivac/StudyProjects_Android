package br.com.impacta.lab_04_formulario;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_nome;
    private EditText et_idade;

    private RadioGroup rg;
    private RadioButton rb_m;
    private RadioButton rb_f;

    private CheckBox cb_sp;

    private Button btn_lerDados;

    private ImageView iv_icon;

    private String nome;
    private String idade;
    private String sexo;
    private String estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {
        context = MainActivity.this;

        et_nome = findViewById(R.id.et_nome);
        et_idade = findViewById(R.id.et_idade);

        rg = findViewById(R.id.rg);

        rb_m = findViewById(R.id.rb_m);
        rb_f = findViewById(R.id.rb_f);

        cb_sp = findViewById(R.id.cb_sp);

        btn_lerDados = findViewById(R.id.btn_lerDados);

        iv_icon = findViewById(R.id.iv_icon);
    }

    private void inicializarAcoes() {

        verificaSexo();

        btn_lerDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nome = et_nome.getText().toString().trim();
                idade = et_idade.getText().toString();
                verificaEstado();
                validacao();
            }
        });

    }

    private void verificaSexo() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId)
                {
                    case R.id.rb_m:
                        sexo = "Masculino";
                        iv_icon.setImageResource(R.drawable.man);
                        break;
                    case R.id.rb_f:
                        sexo = "Feminino";
                        iv_icon.setImageResource(R.drawable.woman);
                        break;
                    default:
                        sexo = "";
                        break;
                }
            }
        });
    }

    private void verificaEstado()
    {
        if (cb_sp.isChecked())
        {
            estado = "São Paulo";
        }else
            {
                estado = "Outros";
            }
    }

    private void validacao() {

        if (!nome.equals("") && !idade.equals("") && sexo != null)
        {
            Toast.makeText(context,
                    "Nome: " + nome +
                            " | Idade: " + idade +
                            " | Sexo: " + sexo +
                            " | Estado: " + estado, Toast.LENGTH_SHORT).show();
        }
        else if (nome.equals(""))
        {
            Toast.makeText(context,"Campo nome é obrigatório", Toast.LENGTH_SHORT).show();
            et_nome.requestFocus();
        }
        else if (idade.equals(""))
        {
            Toast.makeText(context,"Campo idade é obrigatório", Toast.LENGTH_SHORT).show();
            et_idade.requestFocus();
        }
        else if (sexo == null)
        {
            Toast.makeText(context,"Campo sexo é obrigatório", Toast.LENGTH_SHORT).show();
        }

    }
}
