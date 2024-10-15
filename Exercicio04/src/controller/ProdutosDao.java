package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Produtos;

public class ProdutosDao {

    ConexaoBanco conexao = new ConexaoBanco();

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ProdutosDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }

    public void inserirProduto(Produtos produto) {
        String query = "INSERT INTO produtos04 (nome, preco, quantidade) VALUES (?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getPreco());
            pst.setInt(3, produto.getQuantidade());
            int inserir = pst.executeUpdate();
            if (inserir > 0) {
                JOptionPane.showMessageDialog(null, "Produto registrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha no registro do produto!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());
        }
    }

    public ResultSet pesquisarProdutos(Produtos produto) {
        String query = "SELECT * FROM produtos04 WHERE nome like ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, "%" + produto.getNome() + "%");
            rs = pst.executeQuery();

            if (rs != null) {
                return rs;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado.");
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto no banco: " + e.getMessage());
            return null;
        }
    }

    public void editarQtdProdutoNoEstoque(int qtdEstAtualizada, int idProd) {
        String query = "UPDATE produtos04 p SET p.quantidade=? WHERE p.idProd=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, qtdEstAtualizada);
            pst.setInt(2, idProd);

            int editar = pst.executeUpdate();
            if (editar > 0) {
                JOptionPane.showMessageDialog(null, "Quantidade do Produto atualizado com sucesso!");
            } else {
                try {
                    JOptionPane.showMessageDialog(null, "DEU CERTOOOOO!!!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha na atualizacão da quantidade produto!" + e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
    
    public void editarQtdProdutoVendida(int qtdVendida, int idProd) {
        String query = "UPDATE produtos04 p SET p.qtdVendiada=? WHERE p.idProd=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, qtdVendida);
            pst.setInt(2, idProd);

            int editar = pst.executeUpdate();
            if (editar > 0) {
                JOptionPane.showMessageDialog(null, "Quantidade vendida do Produto atualizado com sucesso!");
            } else {
                try {
                    JOptionPane.showMessageDialog(null, "DEU CERTOOOOO!!!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Falha na atualizacão da quantidade vendida do produto!" + e.getMessage());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
}
