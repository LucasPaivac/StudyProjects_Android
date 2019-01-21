package br.com.impacta.lab_02_login;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private EditText et_nome;
    private EditText et_senha;

    private Button btn_cancelar;
    private Button btn_login;

    private String mensagem;

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
        et_senha = findViewById(R.id.et_senha);

        btn_cancelar = findViewById(R.id.btn_cancelar);
        btn_login = findViewById(R.id.btn_login);
    }

    private void inicializarAcoes() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validacao()) {
                    analisarLogin(et_nome.getText().toString(), et_senha.getText().toString());
                } else {
                    exibirErro(mensagem);
                }
            }
        });

        btn_cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparDados();
            }
        });
    }

    private boolean validacao() {
        String nome = et_nome.getText().toString().trim();
        String senha = et_senha.getText().toString().trim();

        if (nome.isEmpty()) {
            mensagem = "Erro: Nome é obrigatório!!";
            return false;
        }
        if (senha.isEmpty()) {
            mensagem = "Erro: Senha é obrigatório!!";
            return false;
        }
        return true;
    }

    private void analisarLogin(String sNome, String sSenha) {
        String nome = sNome.trim();
        String senha = sSenha.trim();

        if (!nome.equalsIgnoreCase("Lucas") || !senha.equals("T123")) {
            ToolBox.exibirMensagem(context, "Erro: Credenciais Inválidas");
        } else {
            ToolBox.exibirMensagem(context, "Credenciais Válidas");
        }

    }

    private void exibirErro(String mensagem) {
        ToolBox.exibirMensagem(context, mensagem);
    }

    public void limparDados() {
        et_nome.setText("");
        et_senha.setText("");
        //
        et_nome.requestFocus();
    }

}
