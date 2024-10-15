package view;

import controller.TarefasDao;
import model.Tarefas;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class TelaAdicionarTarefa extends javax.swing.JFrame {

    public TelaAdicionarTarefa() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtDescricao = new javax.swing.JTextField();
        txtDataVenc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTarefas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtIdTarefa = new javax.swing.JTextField();
        btnAdic = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnExc = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Descrição");

        jLabel3.setText("Data Vencimento");

        jLabel4.setText("Pesquisar pelo status");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        tblTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "idTarefas", "nome", "descricao", "data", "status"
            }
        ));
        tblTarefas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTarefasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTarefas);

        jLabel5.setText("Id");

        txtIdTarefa.setEnabled(false);

        btnAdic.setText("Adicionar");
        btnAdic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicActionPerformed(evt);
            }
        });

        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnExc.setText("Excluir");
        btnExc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcActionPerformed(evt);
            }
        });

        jLabel6.setText("Status");

        cboStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "pendente", "concluída", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(txtPesquisa))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(115, 115, 115)
                        .addComponent(txtIdTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnExc)
                            .addGap(38, 38, 38)
                            .addComponent(btnEdit)
                            .addGap(27, 27, 27)
                            .addComponent(btnAdic))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6))
                            .addGap(34, 34, 34)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDescricao, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDataVenc, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDataVenc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdic)
                    .addComponent(btnEdit)
                    .addComponent(btnExc))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // plotando os dados na tabela
        Tarefas tarefa = new Tarefas();
        tarefa.setStatus(txtPesquisa.getText());

        TarefasDao tarefasDao = new TarefasDao();
        ResultSet rs = tarefasDao.pesquisarTarefas(tarefa);
        if (rs != null) {
            tblTarefas.setModel(DbUtils.resultSetToTableModel(rs));
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao achar tarefas!");
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void tblTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTarefasMouseClicked
        // plotando os dados da tarefas no textfields
        int linhaSelecionada = tblTarefas.getSelectedRow();
        txtIdTarefa.setText(tblTarefas.getModel().getValueAt(linhaSelecionada, 0).toString());
        txtNome.setText(tblTarefas.getModel().getValueAt(linhaSelecionada, 1).toString());
        txtDescricao.setText(tblTarefas.getModel().getValueAt(linhaSelecionada, 2).toString());
        txtDataVenc.setText(tblTarefas.getModel().getValueAt(linhaSelecionada, 3).toString());
        //txtStatus.setText(tblTarefas.getModel().getValueAt(linhaSelecionada, 4).toString());
        //btnAdic.setEnabled(false);
        cboStatus.setSelectedItem(tblTarefas.getModel().getValueAt(linhaSelecionada, 4).toString().trim());
    }//GEN-LAST:event_tblTarefasMouseClicked

    private void btnAdicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicActionPerformed
        // adicionando uma tarefa
        if (txtIdTarefa.getText().isEmpty() && txtNome.getText().isEmpty() && txtDescricao.getText().isEmpty() && txtDataVenc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você quer registrar uma nova tarefa? Insira os dados novamente!");
        } else {

            Tarefas tarefa = new Tarefas();
            tarefa.setNome(txtNome.getText());
            tarefa.setDescricao(txtDescricao.getText());
            tarefa.setData(txtDataVenc.getText());
            //tarefa.setStatus(txtStatus.getText());
            tarefa.setStatus(cboStatus.getSelectedItem().toString());

            TarefasDao tarefaDao = new TarefasDao();
            tarefaDao.inserirTarefa(tarefa);
            limparCampos();
        }
    }//GEN-LAST:event_btnAdicActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // editando tarefa
        if (txtIdTarefa.getText().isEmpty() && txtNome.getText().isEmpty() && txtDescricao.getText().isEmpty() && txtDataVenc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você quer editar uma tarefa? Pesquise sua tarefa primeiramente!");
        } else {

            Tarefas tarefa = new Tarefas();
            tarefa.setIdTarefa(Integer.parseInt(txtIdTarefa.getText()));
            tarefa.setNome(txtNome.getText());
            tarefa.setDescricao(txtDescricao.getText());
            tarefa.setData(txtDataVenc.getText());
            //tarefa.setStatus(txtStatus.getText());
            tarefa.setStatus(cboStatus.getSelectedItem().toString());


            TarefasDao tarefaDao = new TarefasDao();
            tarefaDao.editarTarefa(tarefa);
            limparCampos();
        }

    }//GEN-LAST:event_btnEditActionPerformed

    private void btnExcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcActionPerformed
        // deletando uma tarefa
        if (txtIdTarefa.getText().isEmpty() && txtNome.getText().isEmpty() && txtDescricao.getText().isEmpty() && txtDataVenc.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Você quer deletar uma tarefa? Pesquise sua tarefa primeiramente!");
        } else {

            Tarefas tarefa = new Tarefas();
            tarefa.setIdTarefa(Integer.parseInt(txtIdTarefa.getText()));

            TarefasDao tarefaDao = new TarefasDao();
            tarefaDao.deletarTarefa(tarefa);
            limparCampos();
        }
    }//GEN-LAST:event_btnExcActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarTarefa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionarTarefa().setVisible(true);
            }
        });
    }

    public void limparCampos() {
        txtPesquisa.setText("");
        txtIdTarefa.setText("");
        txtNome.setText("");
        txtDescricao.setText("");
        txtDataVenc.setText("");
        //txtStatus.setText("");
        cboStatus.getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdic;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExc;
    private javax.swing.JComboBox<String> cboStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTarefas;
    private javax.swing.JTextField txtDataVenc;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtIdTarefa;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
