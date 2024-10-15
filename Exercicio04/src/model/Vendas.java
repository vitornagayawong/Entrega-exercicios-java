
package model;

import java.util.ArrayList;
import java.util.List;

public class Vendas {
    private int idVenda;
    List<Produtos> listaDeProdutos = new ArrayList<>();

    public Vendas() {
    }

    public Vendas(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }    
    
    public void adicionarProdutoNalista(Produtos produto) {
        listaDeProdutos.add(produto);
    }
    
    public List<Produtos> getListaDeProdutos() {
        return listaDeProdutos;
    }
    
    public double getPrecoTotalDaVenda() {
        double precoTotalDaVenda = 0;
        for(Produtos prod : listaDeProdutos) {
            precoTotalDaVenda += prod.getPrecoTotalPorProduto();
        }
        return precoTotalDaVenda;
    }   
}
