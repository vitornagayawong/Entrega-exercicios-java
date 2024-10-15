package view;

import controller.ProdutosDao;
import controller.ProdutosVendasDao;
import controller.VendasDao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import model.Produtos;
import model.ProdutosVendas;
import model.Vendas;
import net.proteanit.sql.DbUtils;

public class TelaRegistroVendas extends javax.swing.JFrame {

    public TelaRegistroVendas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPesqProd = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProdutosVendas04 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdProd = new javax.swing.JTextField();
        txtQtdEst = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        btnVenderProd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtQtdDesejaVender = new javax.swing.JTextField();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pesquisar produto");

        txtPesqProd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqProdKeyReleased(evt);
            }
        });

        tblProdutosVendas04.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "idProd", "nome", "preco", "quantidade"
            }
        ));
        tblProdutosVendas04.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosVendas04MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProdutosVendas04);

        jLabel2.setText("Id Produto");

        jLabel3.setText("Quantidade no estoque");

        jLabel4.setText("Preço");

        txtIdProd.setEnabled(false);

        txtQtdEst.setEnabled(false);

        txtPreco.setEnabled(false);

        btnVenderProd.setText("Vender");
        btnVenderProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderProdActionPerformed(evt);
            }
        });

        jLabel6.setText("Nome");

        txtNome.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Digite a quantidade que deseja vender");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesqProd, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(129, 129, 129)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQtdEst, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(28, 28, 28)
                                .addComponent(txtQtdDesejaVender, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnVenderProd)))))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPesqProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtQtdEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtQtdDesejaVender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVenderProd))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtPesqProdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqProdKeyReleased
        // pesquisar um produto
        Produtos produto = new Produtos();
        produto.setNome(txtPesqProd.getText());

        ProdutosDao produtosDao = new ProdutosDao();
        ResultSet rs = produtosDao.pesquisarProdutos(produto);

        if (rs != null) {
            tblProdutosVendas04.setModel(DbUtils.resultSetToTableModel(rs));
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum produto encontrado para a pesquisa.");
        }
    }//GEN-LAST:event_txtPesqProdKeyReleased

    private void tblProdutosVendas04MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosVendas04MouseClicked
        // plotando os dados do produto na tabela
        int setar = tblProdutosVendas04.getSelectedRow();
        txtIdProd.setText(tblProdutosVendas04.getModel().getValueAt(setar, 0).toString());
        txtNome.setText(tblProdutosVendas04.getModel().getValueAt(setar, 1).toString());
        txtQtdEst.setText(tblProdutosVendas04.getModel().getValueAt(setar, 2).toString());
        txtPreco.setText(tblProdutosVendas04.getModel().getValueAt(setar, 3).toString());
    }//GEN-LAST:event_tblProdutosVendas04MouseClicked

    private void btnVenderProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderProdActionPerformed
        // vendendo a quantidade desejada
        int qtdEstoque = Integer.parseInt(txtQtdEst.getText());
        int qtdQueDesejaVender = Integer.parseInt(txtQtdDesejaVender.getText());
        double precoProduto = Double.parseDouble(txtPreco.getText());

        if (qtdQueDesejaVender > qtdEstoque) {
            JOptionPane.showMessageDialog(null, "Quantidade desejada maior que a existente no estoque!");
        } else {
            Produtos produto = new Produtos();
            //FALTOU SETAR O ID DO PRODUTO, SENÃO COMO ELE IA IDENTIFICAR QUAL PRODUTO QUE EU QUERIA VENDER????
            produto.setIdProd(Integer.parseInt(txtIdProd.getText()));
            produto.setQuantidade(qtdEstoque - qtdQueDesejaVender);
            produto.setPreco(precoProduto);

            Vendas venda = new Vendas();
            venda.adicionarProdutoNalista(produto);

            ProdutosDao produtosDao = new ProdutosDao();
            produtosDao.editarQtdProdutoNoEstoque(produto.getQuantidade(), produto.getIdProd());

            VendasDao vendasDao = new VendasDao();
            //PRECISO PRIMEIRO PEGAR O IDVENDA DA TABELA VENDAS04 PARA DEPOIS PODER REGISTRAR UM PRODUTOSVENDAS04!!!
            int idVenda = vendasDao.registrarVenda(venda);

            if (idVenda > 0) {

                ProdutosVendasDao produtosVendasDao = new ProdutosVendasDao();
                produtosVendasDao.registrarProdutoVenda(produto.getIdProd(), idVenda);

                limparCampos();
            }
        }
    }//GEN-LAST:event_btnVenderProdActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRegistroVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRegistroVendas.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaRegistroVendas().setVisible(true);
            }
        });
    }

    private void limparCampos() {
        txtIdProd.setText("");
        txtNome.setText("");
        txtPreco.setText("");
        txtQtdEst.setText("");
        txtQtdDesejaVender.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVenderProd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProdutosVendas04;
    private javax.swing.JTextField txtIdProd;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesqProd;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtdDesejaVender;
    private javax.swing.JTextField txtQtdEst;
    // End of variables declaration//GEN-END:variables
}
