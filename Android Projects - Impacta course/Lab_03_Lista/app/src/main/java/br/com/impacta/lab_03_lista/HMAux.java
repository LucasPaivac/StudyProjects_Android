package br.com.impacta.lab_03_lista;

import java.util.HashMap;

public class HMAux extends HashMap<String, String> {

    public static final String ID = "id";
    public static final String DESCRICAO = "descricao";
    @Override
    public String toString() {
        return get(Produto.NOME);
    }
}
