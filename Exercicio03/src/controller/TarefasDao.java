package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Tarefas;

public class TarefasDao {

    ConexaoBanco conexao = new ConexaoBanco();

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TarefasDao() {
        conexao = new ConexaoBanco();
        if (conexao.conectar()) {
            conn = conexao.getConnection();
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }

    public ResultSet pesquisarTarefas(Tarefas tarefa) {
        String query = "SELECT * FROM tarefas WHERE status LIKE ?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, "%" + tarefa.getStatus() + "%");

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

    public void inserirTarefa(Tarefas tarefa) {
        String query = "INSERT INTO tarefas (nome, descricao, data, status) VALUES (?, ?, ?, ?)";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, tarefa.getNome());
            pst.setString(2, tarefa.getDescricao());
            pst.setString(3, tarefa.getData());
            pst.setString(4, tarefa.getStatus());
            int inserir = pst.executeUpdate();
            if (inserir > 0) {
                JOptionPane.showMessageDialog(null, "Tarefa registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha no registro da tarefa!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! " + e.getMessage());
        }
    }

    public void editarTarefa(Tarefas tarefa) {
        String query = "UPDATE tarefas t SET t.nome=?, t.descricao=?, t.data=?, t.status=? WHERE t.idTarefa=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, tarefa.getNome());
            pst.setString(2, tarefa.getDescricao());
            pst.setString(3, tarefa.getData());
            pst.setString(4, tarefa.getStatus());
            pst.setInt(5, tarefa.getIdTarefa());
            int editar = pst.executeUpdate();
            if (editar > 0) {
                JOptionPane.showMessageDialog(null, "Tarefa atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha na atualizacão da tarefa!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
    
    public void deletarTarefa(Tarefas tarefa) {
        String query = "DELETE FROM tarefas WHERE idTarefa=?";
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, tarefa.getIdTarefa());
            int deletar = pst.executeUpdate();
            if (deletar > 0) {
                JOptionPane.showMessageDialog(null, "Tarefa deletada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha na deleção da tarefa!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }
    
    public void marcarTarefaComoConcluida(Tarefas tarefa) {
        String query = "UPDATE tarefas t SET t.status=? WHERE t.idTarefa=?";        
        try {
            pst = conn.prepareStatement(query);            
            pst.setString(1, tarefa.getStatus());
            pst.setInt(2, tarefa.getIdTarefa());
            int editar = pst.executeUpdate();
            if (editar > 0) {
                
                JOptionPane.showMessageDialog(null, "Tarefa atualizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Falha na atualizacão da tarefa!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco!");
        }
    }

}
