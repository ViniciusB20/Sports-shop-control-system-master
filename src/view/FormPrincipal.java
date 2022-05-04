
package view;

import controller.Conexao;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;


import java.awt.Image;
import java.awt.Graphics;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.ImageIcon;
import report.Relatorio;


public class FormPrincipal extends javax.swing.JFrame {

   
    
    public FormPrincipal() {
        initComponents();
        configurarFormulario();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/MVP.jpg"));
        Image image = icon.getImage();
        areaTrabalho = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        menuMedidas = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuItemIMC = new javax.swing.JMenuItem();
        menuItemCalorias = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuSobre = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areaTrabalho.setFont(new java.awt.Font("Tahoma", 0, 18));

        javax.swing.GroupLayout areaTrabalhoLayout = new javax.swing.GroupLayout(areaTrabalho);
        areaTrabalho.setLayout(areaTrabalhoLayout);
        areaTrabalhoLayout.setHorizontalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 703, Short.MAX_VALUE)
        );
        areaTrabalhoLayout.setVerticalGroup(
            areaTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(283, 40));

        menuMedidas.setText(" Controle   |");
        menuMedidas.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem2.setText("Funcionarios");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuMedidas.add(jMenuItem2);

        menuItemIMC.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        menuItemIMC.setText("Fluxo De Caixa");
        menuItemIMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemIMCActionPerformed(evt);
            }
        });
        menuMedidas.add(menuItemIMC);

        menuItemCalorias.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        menuItemCalorias.setText("Clientes Cartão Fidelidade");
        menuItemCalorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCaloriasActionPerformed(evt);
            }
        });
        menuMedidas.add(menuItemCalorias);

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem6.setText("Estoque");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuMedidas.add(jMenuItem6);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem8.setText("Balanço Geral");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        menuMedidas.add(jMenuItem8);

        jMenuBar1.add(menuMedidas);

        menuRelatorio.setText("  Gerar Relatório  |");
        menuRelatorio.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem1.setText("Funcionarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuRelatorio.add(jMenuItem1);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem3.setText("Fluxo De Caixa");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuRelatorio.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem4.setText("Clientes Cartão Fidelidade");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuRelatorio.add(jMenuItem4);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem5.setText("Controle Estoque");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuRelatorio.add(jMenuItem5);

        jMenuBar1.add(menuRelatorio);

        jMenu1.setText(" Opções  |");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jMenuItem7.setText("Cameras");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);
        jMenu1.add(jSeparator1);

        menuSobre.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        menuSobre.setText("Sobre");
        menuSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSobreActionPerformed(evt);
            }
        });
        jMenu1.add(menuSobre);

        menuSair.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        menuSair.setText("Sair");
        menuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSairActionPerformed(evt);
            }
        });
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrabalho)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrabalho)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemIMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemIMCActionPerformed
        abrirFormulario(new FormCaixa());
    }//GEN-LAST:event_menuItemIMCActionPerformed

    private void menuItemCaloriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCaloriasActionPerformed
       abrirFormulario(new FormFidelidade());
    }//GEN-LAST:event_menuItemCaloriasActionPerformed

    private void menuSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSobreActionPerformed
        abrirFormulario(new FormSobree());
    }//GEN-LAST:event_menuSobreActionPerformed

    private void menuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSairActionPerformed
        int resp = JOptionPane.showConfirmDialog(
            null, 
            "Deseja sair da aplicação?",
            "Registro de Notas",
            JOptionPane.YES_NO_OPTION
        );
        
        if (resp == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_menuSairActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Connection con = Conexao.conectar();
        new Relatorio().exibir(con, "relatorio_funcionarios.jrxml");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        abrirFormulario(new FormFuncionario());
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        abrirFormulario(new FormEstoque());
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Connection con = Conexao.conectar();
        new Relatorio().exibir(con, "relatorio_caixa.jrxml");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Connection con = Conexao.conectar();
        new Relatorio().exibir(con, "relatorio_clientes.jrxml");
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Connection con = Conexao.conectar();
        new Relatorio().exibir(con, "relatorio_estoque.jrxml");
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        abrirFormulario(new Cam_Estoque());
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        abrirFormulario(new FormBalanco());
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane areaTrabalho;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem menuItemCalorias;
    private javax.swing.JMenuItem menuItemIMC;
    private javax.swing.JMenu menuMedidas;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JMenuItem menuSair;
    private javax.swing.JMenuItem menuSobre;
    // End of variables declaration//GEN-END:variables

    private void configurarFormulario() {
        this.setTitle("Sistema de controle");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void abrirFormulario(JInternalFrame f) {

        if (areaTrabalho.getAllFrames().length == 0) {
            areaTrabalho.add(f);
            centralizarFormulario(f);
            f.setVisible(true);
        }else{
            JOptionPane.showConfirmDialog(
                rootPane, 
                "Você precisar fechar a janela atual antes de abrir outra.");
        }
        
    }
    
    private void centralizarFormulario(JInternalFrame f) {
        Dimension d = f.getDesktopPane().getSize();
        f.setLocation(
                (d.width - f.getSize().width) / 2,
                (d.height - f.getSize().height) / 2
        );
    }

}
