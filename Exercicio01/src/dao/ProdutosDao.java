package dao;

import java.sql.*;
import javax.swing.JOptionPane;
import modelo.Produtos;
import net.proteanit.sql.DbUtils;

public class ProdutosDao {

    private ConexaoBanco conexao;

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ProdutosDao() {
        conexao = new ConexaoBanco();
        if(conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
    
    public ResultSet pesquisarProdutos(Produtos produto) {
    String query = "SELECT * FROM produtos WHERE nome like ?";
    try {
        pst = conn.prepareStatement(query);
        pst.setString(1, produto.getNome() + "%");
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


    public void inserirProduto(Produtos produto) {
        String query = "INSERT INTO produtos (nome, preco, quantidade, descricao) VALUES (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getPreco());
            pst.setInt(3, produto.getQuantidade());
            pst.setString(4, produto.getDescricao());
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

    public void editarProduto(Produtos produto) {
        String query = "UPDATE produtos p SET p.nome=?, p.preco=?, p.quantidade=?, p.descricao=? WHERE p.idProd=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, produto.getNome());
            pst.setDouble(2, produto.getPreco());
            pst.setInt(3, produto.getQuantidade());
            pst.setString(4, produto.getDescricao());
            pst.setInt(5, produto.getIdProd());
            int editar = pst.executeUpdate();
            if (editar > 0) {
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha na atualizacão do produto!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
    
    public void deletarProduto(Produtos produto) {
        String query = "DELETE FROM produtos WHERE idProd=?";
        try {
            pst = conn.prepareStatement(query);            
            pst.setInt(1, produto.getIdProd());
            int deletar = pst.executeUpdate();
            if (deletar > 0) {
                JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha na deleção do produto!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
    
    

}
