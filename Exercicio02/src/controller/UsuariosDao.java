package controller;

import java.sql.*;
import javax.swing.JOptionPane;
import model.Usuario;

public class UsuariosDao {

    ConexaoBanco conexao = new ConexaoBanco();

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public UsuariosDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }

    public boolean registrar(Usuario usuario) {
        String query = "INSERT INTO usuarios (nome, email, senha) VALUES (?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getEmail());
            pst.setString(3, usuario.getSenha());
            int inserir = pst.executeUpdate();
            if (inserir > 0) {
                JOptionPane.showMessageDialog(null, "Usuário registrado com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha no registro do usuário!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());
            return false;
        }
    }

    public boolean verificarCredeciais(String email, String senha) {
        String query = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, senha);
            rs = pst.executeQuery();   
            if(rs.next()){
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());
            return false;
        }
    }
}
