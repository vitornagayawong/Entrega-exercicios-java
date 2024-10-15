
package model;


public class Produtos {
    private int idProd;
    private String nome;
    private double preco;
    private int quantidade;
    
    public Produtos(){        
    }

    public Produtos(int idProd, String nome, double preco, int quantidade) {
        this.idProd = idProd;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
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

    public double getPrecoTotalPorProduto() {
        return this.quantidade * this.preco;
    }
}
