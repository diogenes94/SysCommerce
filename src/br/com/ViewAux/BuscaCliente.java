/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ViewAux;

import br.com.control.Controlador;
import br.com.model.ClienteModel;
import br.com.tabelas.TabelaBuscaCliente;
import br.com.utils.FormataData;
import br.com.utils.InsereMascara;
import br.com.view.TelaCliente;
import br.com.view.TelaPrincipal;
import java.awt.Dialog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author diogenes.francisco
 */
public class BuscaCliente extends javax.swing.JDialog {

    /**
     * Creates new form BuscaCliente
     */
    TelaPrincipal father;
    Dialog pai;

    public BuscaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
    }

    public BuscaCliente(java.awt.Frame parent, boolean modal, String busca, Dialog pai) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jTPesquisa.setText(busca);
        this.pai = pai;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTPesquisa = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Clientes");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisar"));

        jTPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisaKeyReleased(evt);
            }
        });

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/magnifying47.png"))); // NOI18N
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPesquisa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscar))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new TabelaBuscaCliente(new LinkedList<ClienteModel>()));
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/accepted.png"))); // NOI18N
        jButton1.setText("Ok");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/door13.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(24, 24, 24))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        Controlador c = new Controlador();
        TabelaBuscaCliente model = (TabelaBuscaCliente) jTable1.getModel();
        model.limpaTabela();
        ResultSet rs = c.pesquisaCliente("%" + jTPesquisa.getText() + "%", jTPesquisa.getText());
        try {
            while (rs.next()) {
                String cpfCnpj;
                Boolean ativo = true;
                if (rs.getString("Tipo_Cliente").equals("J")) {
                    cpfCnpj = InsereMascara.insereMascCnpj(rs.getString("cnpj"));
                } else {
                    cpfCnpj = InsereMascara.insereMascCpf(rs.getString("cpf"));
                }
                if (rs.getString("ativo").equals("0")) {
                    ativo = false;
                }
                model.addLinha(new ClienteModel(rs.getString("id"), rs.getString("Nome"), cpfCnpj, ativo));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBBuscarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Controlador c = new Controlador();
        TabelaBuscaCliente model = (TabelaBuscaCliente) jTable1.getModel();
        model.limpaTabela();
        ResultSet rs = c.pesquisaCliente("%" + jTPesquisa.getText() + "%", jTPesquisa.getText());
        try {
            while (rs.next()) {
                String cpfCnpj;
                Boolean ativo = true;
                if (rs.getString("Tipo_Cliente").equals("J")) {
                    cpfCnpj = InsereMascara.insereMascCnpj(rs.getString("cnpj"));
                } else {
                    cpfCnpj = InsereMascara.insereMascCpf(rs.getString("cpf"));
                }
                if (rs.getString("ativo").equals("0")) {
                    ativo = false;
                }
                model.addLinha(new ClienteModel(rs.getString("id"), rs.getString("Nome"), cpfCnpj, ativo));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_formWindowOpened

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTable1.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this, "Nenhuma linha selecionada", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Controlador c = new Controlador();
        String codigo = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
        ResultSet rs = c.pesquisaClienteId(codigo);
        try {
            if (rs.next()) {
                ClienteModel cli = new ClienteModel();
                cli.setNome(rs.getString("Nome"));
                cli.setNomeFantasia(rs.getString("NomeFantasia"));
                cli.setId(rs.getString("id"));
                cli.setCpf(rs.getString("cpf"));
                cli.setCnpj(rs.getString("cnpj"));
                cli.setRg(rs.getString("rg"));
                cli.setDataNasc(rs.getString("Data_Nasc"));
                cli.setNaturalidade(rs.getString("Naturalidade"));
                cli.setIe(rs.getString("ie"));
                cli.setEndereco(rs.getString("Endereco"));
                cli.setNumero(rs.getString("Numero"));
                cli.setComplemento(rs.getString("Complemento"));
                cli.setBairro(rs.getString("Bairro"));
                cli.setCidade(rs.getString("Cidade"));
                cli.setCep(rs.getString("cep"));
                cli.setEstado(rs.getString("Estado"));
                cli.setContato(rs.getString("Contato"));
                cli.setContato2(rs.getString("Contato2"));
                cli.setEmail(rs.getString("Email"));
                cli.setObservacao(rs.getString("Observacao"));
                cli.setDataAlteracao(rs.getString("Data_Alteracao"));
                cli.setUsuario(rs.getString("login"));
                cli.setTipoCliente(rs.getString("Tipo_Cliente"));
                cli.setSexo(rs.getString("Sexo"));
                if (rs.getInt("Ativo") == 0) {
                    cli.setAtivo(false);
                } else {
                    cli.setAtivo(true);
                }

                pai.dispose();
                TelaCliente tela = new TelaCliente(father, true, cli);
                tela.setVisible(true);
                this.dispose();
            }
        } catch (Exception ex) {
            Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            Controlador c = new Controlador();
            String codigo = (String) jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0);
            ResultSet rs = c.pesquisaClienteId(codigo);
            try {
                if (rs.next()) {
                    ClienteModel cli = new ClienteModel();
                    cli.setNome(rs.getString("Nome"));
                    cli.setNomeFantasia(rs.getString("NomeFantasia"));
                    cli.setId(rs.getString("id"));
                    cli.setCpf(rs.getString("cpf"));
                    cli.setCnpj(rs.getString("cnpj"));
                    cli.setRg(rs.getString("rg"));
                    cli.setDataNasc(rs.getString("Data_Nasc"));
                    cli.setNaturalidade(rs.getString("Naturalidade"));
                    cli.setIe(rs.getString("ie"));
                    cli.setEndereco(rs.getString("Endereco"));
                    cli.setNumero(rs.getString("Numero"));
                    cli.setComplemento(rs.getString("Complemento"));
                    cli.setBairro(rs.getString("Bairro"));
                    cli.setCidade(rs.getString("Cidade"));
                    cli.setCep(rs.getString("cep"));
                    cli.setEstado(rs.getString("Estado"));
                    cli.setContato(rs.getString("Contato"));
                    cli.setContato2(rs.getString("Contato2"));
                    cli.setEmail(rs.getString("Email"));
                    cli.setObservacao(rs.getString("Observacao"));
                    cli.setDataAlteracao(rs.getString("Data_Alteracao"));
                    cli.setUsuario(rs.getString("login"));
                    cli.setTipoCliente(rs.getString("Tipo_Cliente"));
                    cli.setSexo(rs.getString("Sexo"));
                    if (rs.getInt("Ativo") == 0) {
                        cli.setAtivo(false);
                    } else {
                        cli.setAtivo(true);
                    }
                    pai.dispose();
                    TelaCliente tela = new TelaCliente(father, true, cli);
                    tela.setVisible(true);
                    this.dispose();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisaKeyReleased
        Controlador c = new Controlador();
        TabelaBuscaCliente model = (TabelaBuscaCliente) jTable1.getModel();
        model.limpaTabela();
        ResultSet rs = c.pesquisaCliente("%" + jTPesquisa.getText() + "%", jTPesquisa.getText());
        try {
            while (rs.next()) {
                String cpfCnpj;
                Boolean ativo = true;
                if (rs.getString("Tipo_Cliente").equals("J")) {
                    cpfCnpj = InsereMascara.insereMascCnpj(rs.getString("cnpj"));
                } else {
                    cpfCnpj = InsereMascara.insereMascCpf(rs.getString("cpf"));
                }
                if (rs.getString("ativo").equals("0")) {
                    ativo = false;
                }
                model.addLinha(new ClienteModel(rs.getString("id"), rs.getString("Nome"), cpfCnpj, ativo));

            }
        } catch (SQLException ex) {
            Logger.getLogger(BuscaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTPesquisaKeyReleased

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
            java.util.logging.Logger.getLogger(BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuscaCliente dialog = new BuscaCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTPesquisa;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
