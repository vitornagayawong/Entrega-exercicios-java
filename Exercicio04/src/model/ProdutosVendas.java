
package model;


public class ProdutosVendas {
    private Produtos produto;
    private Vendas venda;

    public ProdutosVendas() {
    }

    public ProdutosVendas(Produtos produto, Vendas venda) {
        this.produto = produto;
        this.venda = venda;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Vendas getVenda() {
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }        
    
}
