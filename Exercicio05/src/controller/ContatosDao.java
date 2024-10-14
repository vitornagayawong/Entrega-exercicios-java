package controller;

import java.sql.*;
import javax.swing.JOptionPane;
import model.Contatos;

public class ContatosDao {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    ConexaoBanco conexao = null;

    public ContatosDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar co m o banco!");
        }
    }
    
    public void inserirContato(Contatos contato) {
        String query = "INSERT INTO contatos (nome, telefone, email, endereco) VALUES (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, contato.getNome());
            pst.setString(2, contato.getTelefone());
            pst.setString(3, contato.getEmail());
            pst.setString(4, contato.getEndereco());
            int inserir = pst.executeUpdate();
            if (inserir > 0) {
                JOptionPane.showMessageDialog(null, "Contato registrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha no registro do contato!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());
        }
    }

    public ResultSet pesquisarContatos(Contatos contatos) {
        String query = "SELECT * FROM contatos WHERE nome LIKE ? OR telefone LIKE ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, "%" + contatos.getNome() + "%");
            pst.setString(2, "%"  + contatos.getTelefone() + "%");
            rs = pst.executeQuery();

            if (rs != null) {
                return rs;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum contato encontrado.");
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar contato no banco: " + e.getMessage());
            return null;
        }
    }

    public boolean editarContato(Contatos contato) {
        String query = "UPDATE contatos c SET c.nome=?, c.telefone=?, c.email=?, c.endereco=? WHERE c.idContato=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, contato.getNome());
            pst.setString(2, contato.getTelefone());
            pst.setString(3, contato.getEmail());
            pst.setString(4, contato.getEndereco());
            pst.setInt(5, contato.getIdContato());
            int editar = pst.executeUpdate();
            if (editar > 0) {
                JOptionPane.showMessageDialog(null, "Contato atualizado com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha na atualizacão do contato!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
            return false;
        }
    }

    public void deletarContato(Contatos contato) {
        String query = "DELETE FROM contatos WHERE idContato=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, contato.getIdContato());
            int deletar = pst.executeUpdate();
            if (deletar > 0) {
                JOptionPane.showMessageDialog(null, "Contato deletado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha na deleção do contato!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
}
