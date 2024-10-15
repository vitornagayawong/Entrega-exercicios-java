package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Produtos;
import model.Vendas;

public class VendasDao {

    ConexaoBanco conexao = new ConexaoBanco();

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public VendasDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }

    public int registrarVenda(Vendas venda) {
        String query = "INSERT INTO vendas04 (idVenda) VALUES (?)";
        try {
            pst = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            pst.setInt(1, venda.getIdVenda());

            int inserir = pst.executeUpdate();

            if (inserir > 0) {
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idVenda = generatedKeys.getInt(1);
                    venda.setIdVenda(idVenda);
                    return idVenda;
                }
                JOptionPane.showMessageDialog(null, "Venda registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha no registro da venda!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());
        }
        return -1;
    }

    public int pesquisarVendas(int idVenda) {
        String query = "SELECT * FROM vendas04 WHERE idVenda=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, idVenda);
            rs = pst.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "idVenda encontrado com sucesso!");
                return idVenda;
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível encontrar o idVenda!");
                return 0;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());
            return 0;
        }
    }

    
}
