package br.com.impacta.lab_03_lista;

public class Produto {

    public static final String IDPRODUTO = "idproduto";
    public static final String NOME = "nome";
    public static final String PRECO = "preco";
    public static final String QUANTIDADE = "quantidade";

    private long idProduto;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto() {
        this.idProduto = -1;
        this.nome = "<Selecione a tabela>";
        this.preco = -1;
        this.quantidade = -1;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return nome;
    }

}
