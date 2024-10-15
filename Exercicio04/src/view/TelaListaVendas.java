package view;

import controller.ProdutosVendasDao;
import controller.VendasDao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ProdutosVendas;
import java.sql.*;
import model.Produtos;
import model.Vendas;
import net.proteanit.sql.DbUtils;

public class TelaListaVendas extends javax.swing.JFrame {

    public TelaListaVendas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPesqProdVenda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVisuProdVendas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtIdVenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtProd = new javax.swing.JTextField();
        txtQtdEstoque = new javax.swing.JTextField();
        txtValTot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIdProd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pesquisar id");

        txtPesqProdVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesqProdVendaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqProdVendaKeyReleased(evt);
            }
        });

        tblVisuProdVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "idProd", "idVenda"
            }
        ));
        tblVisuProdVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVisuProdVendasMouseClicked(evt);
            }
        });
        tblVisuProdVendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblVisuProdVendasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVisuProdVendas);

        jLabel2.setText("idVenda");

        jLabel3.setText("Produto");

        jLabel4.setText("Qtd no Estoque");

        jLabel5.setText("Valor Total Venda");

        jLabel6.setText("idProduto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesqProdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtProd, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtIdProd, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtIdVenda, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtValTot, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(txtQtdEstoque))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesqProdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtValTot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblVisuProdVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVisuProdVendasMouseClicked
        
        
        int linhaSelecionada = tblVisuProdVendas.getSelectedRow();

       
        int idProd = Integer.parseInt(tblVisuProdVendas.getModel().getValueAt(linhaSelecionada, 0).toString());
        int idVenda = Integer.parseInt(tblVisuProdVendas.getModel().getValueAt(linhaSelecionada, 1).toString());

        
        txtIdProd.setText(String.valueOf(idProd));
        txtIdVenda.setText(String.valueOf(idVenda));

        try {
            
            ProdutosVendasDao produtosVendasDao = new ProdutosVendasDao();
            Produtos produto = produtosVendasDao.obterProdutoPorId(idProd);

            if (produto != null) {
                txtProd.setText(produto.getNome());  // Nome do produto
                txtQtdEstoque.setText(String.valueOf(produto.getQuantidade()));  // Quantidade no estoque
            } else {
                JOptionPane.showMessageDialog(null, "Produto não encontrado.");
            }
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + e.getMessage());
        }

    }//GEN-LAST:event_tblVisuProdVendasMouseClicked

    private void txtPesqProdVendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqProdVendaKeyReleased
        // plotando os dados da venda na tabela;
        String pesquisa = txtPesqProdVenda.getText();

        if (!pesquisa.isEmpty()) {
            try {
                int idGenerico = Integer.parseInt(pesquisa);

                ProdutosVendasDao produtosVendasDao = new ProdutosVendasDao();
                ResultSet rs = produtosVendasDao.pesquisarProdutoVenda(idGenerico, idGenerico);

                if (rs != null) {
                    // Exibir o resultado na tabela usando DbUtils para converter o ResultSet
                    tblVisuProdVendas.setModel(DbUtils.resultSetToTableModel(rs));
                } else {
                    JOptionPane.showMessageDialog(null, "Nenhum resultado encontrado.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "ID inválido. Digite um número inteiro.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar venda: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_txtPesqProdVendaKeyReleased

    private void txtPesqProdVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqProdVendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesqProdVendaKeyPressed

    private void tblVisuProdVendasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVisuProdVendasKeyPressed

    }//GEN-LAST:event_tblVisuProdVendasKeyPressed

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
            java.util.logging.Logger.getLogger(TelaListaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaListaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaListaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListaVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVisuProdVendas;
    private javax.swing.JTextField txtIdProd;
    private javax.swing.JTextField txtIdVenda;
    private javax.swing.JTextField txtPesqProdVenda;
    private javax.swing.JTextField txtProd;
    private javax.swing.JTextField txtQtdEstoque;
    private javax.swing.JTextField txtValTot;
    // End of variables declaration//GEN-END:variables
}
