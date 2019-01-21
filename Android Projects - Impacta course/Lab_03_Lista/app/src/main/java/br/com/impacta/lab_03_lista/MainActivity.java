package br.com.impacta.lab_03_lista;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private Spinner sp_precos;
    private ArrayList<HMAux> precos;
    private ArrayAdapter<HMAux> adapter_precos;

    private Spinner sp_produtos;
    private ArrayList<HMAux> produtosTabela1;
    private ArrayAdapter<HMAux> adapter_produtosTabela1;


    private EditText et_quantidade;

    private TextView tv_valor_total;

    private String tabela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_inicial);

        inicializarVariaveis();
        inicializarAcoes();

    }

    private void inicializarVariaveis() {
        context = MainActivity.this;

        gerarSpinner01();



    }

    public void gerarSpinner01()
    {
        //Tabela de Precos

        sp_precos = findViewById(R.id.sp_precos);
        //
        gerarPrecos(2);
        //
        adapter_precos = new ArrayAdapter<HMAux>(
                context,
                android.R.layout.simple_spinner_item,
                precos
        );
        adapter_precos.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //
        sp_precos.setAdapter(adapter_precos);

        //Puxar os dados
        Produto tabelaDePreco_selecionada = (Produto) sp_precos.getSelectedItem();
    }

    private void gerarPrecos(int quantidade) {
        precos = new ArrayList<>();

        precos.add(new HMAux());

        for (int i = 1; i <= quantidade; i++) {
            Produto pAux = new Produto();
            pAux.setIdProduto(i);
            pAux.setNome("Tabela - " + String.valueOf(i));
            //
            precos.add(pAux);
        }
    }

    private void inicializarAcoes() {
    }
}
