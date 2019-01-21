package br.com.impacta.lab_02_login;

import android.content.Context;
import android.widget.Toast;

public class ToolBox {
    public static void exibirMensagem(Context context, String mensagem)
    {
        Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
    }
}
