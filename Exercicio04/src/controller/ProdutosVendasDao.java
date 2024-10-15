package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Produtos;
import model.Vendas;

public class ProdutosVendasDao {

    ConexaoBanco conexao = new ConexaoBanco();

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ProdutosVendasDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }

    public void registrarProdutoVenda(int idProd, int idVenda) {
        String query = "INSERT INTO produtosVendas04 (idProd, idVenda) VALUES (?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, idProd);
            pst.setInt(2, idVenda);

            int inserir = pst.executeUpdate();

            if (inserir > 0) {
                JOptionPane.showMessageDialog(null, "ProdutosVendas registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha no registro do ProdutosVendas!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());
        }
    }

    public ResultSet pesquisarProdutoVenda(int idVenda, int idProd) {
        String query = "SELECT * FROM produtosVendas04 WHERE idVenda=? OR idProd=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, idVenda);
            pst.setInt(2, idProd);
            rs = pst.executeQuery();

            return rs;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());

        }
        return null;
    }

    public Produtos obterProdutoPorId(int idProd) {
        Produtos produto = null;
        String sql = "SELECT nome, quantidade FROM produtos04 WHERE idProd = ?";

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, idProd);
            rs = pst.executeQuery();

            if (rs.next()) {
                produto = new Produtos();
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e.getMessage());
        }
        return produto;
    }

}
