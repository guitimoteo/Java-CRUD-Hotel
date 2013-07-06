/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import VO.Quarto;

/**
 *
 * @author Line
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCadHospede = new javax.swing.JButton();
        lblHotel = new javax.swing.JLabel();
        btnCadQuarto = new javax.swing.JButton();
        btncadFuncionario = new javax.swing.JButton();
        btnCadProduto = new javax.swing.JButton();
        btnCadServico = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu Principal");

        btnCadHospede.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        btnCadHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/CadHospede.png"))); // NOI18N
        btnCadHospede.setText("Cadastro de Hóspede");
        btnCadHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadHospedeActionPerformed(evt);
            }
        });

        lblHotel.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        lblHotel.setText("Nome do Sistema");

        btnCadQuarto.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        btnCadQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/CadQuarto.png"))); // NOI18N
        btnCadQuarto.setText("Cadastro de Quarto");
        btnCadQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadQuartoActionPerformed(evt);
            }
        });

        btncadFuncionario.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        btncadFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/CadFuncionario.png"))); // NOI18N
        btncadFuncionario.setText("Cadastro de Funcionário");
        btncadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncadFuncionarioActionPerformed(evt);
            }
        });

        btnCadProduto.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        btnCadProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/CadProduto.png"))); // NOI18N
        btnCadProduto.setText("Cadastro de Produto");
        btnCadProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadProdutoActionPerformed(evt);
            }
        });

        btnCadServico.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        btnCadServico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/cadServico.png"))); // NOI18N
        btnCadServico.setText("Cadastro de Serviço");
        btnCadServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadServicoActionPerformed(evt);
            }
        });

        btnSair.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagem/sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadHospede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadQuarto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btncadFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                            .addComponent(btnCadProduto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadServico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(lblHotel)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblHotel)
                .addGap(27, 27, 27)
                .addComponent(btnCadQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCadHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btncadFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadServico, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        //Fecha todo o sistema quando clica 
        System.exit (0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnCadQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadQuartoActionPerformed
        // Vai para a tela de Cadastro de Quartos 
        ControlerQuarto quarto = new ControlerQuarto();
        quarto.show();
        this.setVisible(false);
    }//GEN-LAST:event_btnCadQuartoActionPerformed

    private void btnCadHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadHospedeActionPerformed
        // Vai para a tela de Cadastro de Hóspede
        ControlerHospede hospede = new ControlerHospede();
        hospede.show();
        this.setVisible(false);
    }//GEN-LAST:event_btnCadHospedeActionPerformed

    private void btncadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncadFuncionarioActionPerformed
        // Vai para a tela de Cadastro de Funcionário
        ControlerFuncionario funcionario = new ControlerFuncionario();
        funcionario.show();
        this.setVisible(false);
    }//GEN-LAST:event_btncadFuncionarioActionPerformed

    private void btnCadProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadProdutoActionPerformed
        // Vai para a tela de Cadastro de Produto
        ControlerProduto produto = new ControlerProduto();
        produto.show();
        this.setVisible(false);
    }//GEN-LAST:event_btnCadProdutoActionPerformed

    private void btnCadServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadServicoActionPerformed
        // Vai para a tela de Cadastro de Produto
        ControlerServico servico = new ControlerServico();
        servico.show();
        this.setVisible(false);
    }//GEN-LAST:event_btnCadServicoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadHospede;
    private javax.swing.JButton btnCadProduto;
    private javax.swing.JButton btnCadQuarto;
    private javax.swing.JButton btnCadServico;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btncadFuncionario;
    private javax.swing.JLabel lblHotel;
    // End of variables declaration//GEN-END:variables
}