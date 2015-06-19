/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.Renderer.CellRender;
import br.com.ViewAux.BuscaFornecedor;
import br.com.control.Controlador;
import br.com.model.FornecedorModel;
import br.com.model.ProdutoModel;
import br.com.tabelas.TabelaNotaEntrada;
import br.com.utils.FormataDinheiro;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author diogenes.francisco
 */
public class TelaNotaEntrada extends javax.swing.JDialog {

    /**
     * Creates new form TelaNotaEntrada
     */
    TelaPrincipal father;
    Integer idForn;

    public TelaNotaEntrada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
    }

    public TelaNotaEntrada(java.awt.Frame parent, boolean modal, FornecedorModel forn) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        this.jTRazaoSocial.setText(forn.getRazaoSocial());
        this.jTCnpj.setText(forn.getCnpj());
        this.jTCidade.setText(forn.getCidade());
        this.jTUF.setText(forn.getEstado());
        this.idForn = Integer.parseInt(forn.getId());
        jTNumNota.setEnabled(true);
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
        jTPesquisar = new javax.swing.JTextField();
        jBtnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTRazaoSocial = new javax.swing.JTextField();
        jTCnpj = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTCidade = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTUF = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTNumNota = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jBtnAdd = new javax.swing.JButton();
        jBtnApagaTudo = new javax.swing.JButton();
        jBtnSalvar = new javax.swing.JButton();
        jBtnExclui = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jBtnSair = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTVlrNota = new javax.swing.JTextField();
        jTQuantProduto = new javax.swing.JTextField();
        jBtnAtualizaTotal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lançamento de Notas Entrada");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Pesquisa"));

        jTPesquisar.setNextFocusableComponent(jTNumNota);
        jTPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTPesquisarFocusLost(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/magnifying47.png"))); // NOI18N
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("Código Fornecedor :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jBtnPesquisar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Dados Fornecedor"));

        jLabel2.setText("Razão Social :");

        jTRazaoSocial.setEditable(false);

        jTCnpj.setEditable(false);
        try {
            jTCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("CNPJ :");

        jLabel4.setText("Cidade :");

        jTCidade.setEditable(false);

        jLabel5.setText("Estado :");

        jTUF.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTRazaoSocial)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTUF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTRazaoSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jTUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jTCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new TabelaNotaEntrada(new LinkedList<ProdutoModel>(),this));
        jTable1.setDefaultRenderer(Object.class, new CellRender());
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);
        jTable1.setSelectionBackground(new java.awt.Color(51, 204, 255));
        jTable1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTable1FocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("Nº Nota Fiscal :");

        jTNumNota.setEnabled(false);
        jTNumNota.setNextFocusableComponent(jBtnAdd);
        jTNumNota.setOpaque(false);
        jTNumNota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTNumNotaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTNumNota, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTNumNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Hospital_symbol_24.png"))); // NOI18N
        jBtnAdd.setToolTipText("Inserir Produto");
        jBtnAdd.setEnabled(false);
        jBtnAdd.setNextFocusableComponent(jTable1);
        jBtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddActionPerformed(evt);
            }
        });

        jBtnApagaTudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/back57.png"))); // NOI18N
        jBtnApagaTudo.setToolTipText("Desfazer Tudo");
        jBtnApagaTudo.setEnabled(false);
        jBtnApagaTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnApagaTudoActionPerformed(evt);
            }
        });

        jBtnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/save31.png"))); // NOI18N
        jBtnSalvar.setToolTipText("Salvar");
        jBtnSalvar.setEnabled(false);

        jBtnExclui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Minus_sign_in_filled_circle_24.png"))); // NOI18N
        jBtnExclui.setToolTipText("Excluir Produto");
        jBtnExclui.setEnabled(false);
        jBtnExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAdd)
                    .addComponent(jBtnExclui)
                    .addComponent(jBtnApagaTudo)
                    .addComponent(jBtnSalvar))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jBtnAdd, jBtnExclui, jBtnSalvar});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnExclui)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnApagaTudo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(jBtnSalvar)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jBtnAdd, jBtnExclui, jBtnSalvar});

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jBtnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/door13.png"))); // NOI18N
        jBtnSair.setText("Sair");
        jBtnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnSair)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Quantidade de produtos :");

        jLabel7.setText("Valor Total da Nota :");

        jTVlrNota.setEditable(false);

        jTQuantProduto.setEditable(false);
        jTQuantProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jBtnAtualizaTotal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/icones/Actualize_arrows_couple_in_circle_24.png"))); // NOI18N
        jBtnAtualizaTotal.setToolTipText("Atualizar total");
        jBtnAtualizaTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAtualizaTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTQuantProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTVlrNota, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnAtualizaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAtualizaTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jTVlrNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTQuantProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSairActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        if (jTPesquisar.getText().equals("")) {
            new BuscaFornecedor(null, true, jTPesquisar.getText(), this).setVisible(true);
        }
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jTPesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTPesquisarFocusLost
        if (!jTPesquisar.getText().equals("")) {
            try {
                Controlador c = new Controlador();
                ResultSet rs = c.pesquisaFornecedor(jTPesquisar.getText(), "%" + jTPesquisar.getText() + "%");
                if (rs.last() && rs.getRow() == 1) {
                    rs.first();
                    FornecedorModel forn = new FornecedorModel();
                    forn.setId(rs.getString("id"));
                    forn.setRazaoSocial(rs.getString("razao_social"));
                    forn.setCnpj(rs.getString("cnpj"));
                    forn.setCidade(rs.getString("Cidade"));
                    forn.setEstado(rs.getString("Estado"));

                    this.dispose();
                    TelaNotaEntrada tela = new TelaNotaEntrada(father, true, forn);
                    tela.setVisible(true);

                } else {
                    new BuscaFornecedor(null, true, jTPesquisar.getText(), this).setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TelaFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jTPesquisarFocusLost

    private void jTNumNotaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTNumNotaFocusLost
        Controlador c = new Controlador();
        ResultSet rs = c.validaNfExiste(idForn.toString(), jTNumNota.getText());
        try {
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "Nota já lançada anteriormente para este fornecedor!", "ERRO", JOptionPane.ERROR_MESSAGE);
                jTNumNota.setText(null);
                jTNumNota.requestFocus();
            } else if (jTNumNota.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Campo Nº Nota Fiscal vazio!", "ERRO", JOptionPane.ERROR_MESSAGE);
                jTNumNota.requestFocus();
            } else {
                jBtnAdd.setEnabled(true);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelaNotaEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTNumNotaFocusLost

    private void jBtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddActionPerformed
        TabelaNotaEntrada model = (TabelaNotaEntrada) jTable1.getModel();
        model.addLinha(new ProdutoModel());
        jTQuantProduto.setText(String.valueOf(jTable1.getRowCount()));
        jBtnApagaTudo.setEnabled(true);
        jBtnExclui.setEnabled(true);
        jBtnSalvar.setEnabled(true);
        jTPesquisar.setEnabled(false);
        jTNumNota.setEditable(false);
        jTable1.addRowSelectionInterval(jTable1.getRowCount() - 1, jTable1.getRowCount() - 1);

    }//GEN-LAST:event_jBtnAddActionPerformed

    private void jBtnExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluiActionPerformed
        TabelaNotaEntrada model = (TabelaNotaEntrada) jTable1.getModel();
        model.removeRow(jTable1.getSelectedRow());
        if (jTable1.getRowCount() > 0) {
            jTable1.addRowSelectionInterval(jTable1.getRowCount() - 1, jTable1.getRowCount() - 1);
        }
        if (jTable1.getRowCount() == 0) {
            jBtnExclui.setEnabled(false);
            jBtnSalvar.setEnabled(false);
        }
    }//GEN-LAST:event_jBtnExcluiActionPerformed

    private void jBtnApagaTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnApagaTudoActionPerformed
        TabelaNotaEntrada model = (TabelaNotaEntrada) jTable1.getModel();
        model.limpaTabela();
        jTNumNota.setText(null);
        jTQuantProduto.setText(null);
        jTVlrNota.setText(null);
        jTPesquisar.setEnabled(true);
        jTNumNota.setEnabled(false);
        jBtnApagaTudo.setEnabled(false);
        jBtnExclui.setEnabled(false);
        jBtnSalvar.setEnabled(false);
        jBtnAdd.setEnabled(false);

    }//GEN-LAST:event_jBtnApagaTudoActionPerformed

    private void jTable1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTable1FocusLost
        if (jTable1.getRowCount() > 0 && ((String) jTable1.getValueAt(0, 4) != null)) {
            Double total = 0.0;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                total = total + FormataDinheiro.moneyForCalc((String) jTable1.getValueAt(i, 4));
            }
            if(total > 0)
                jTVlrNota.setText(FormataDinheiro.moneyForApp(total));
            //System.out.println("existe linha com valor");
        }
    }//GEN-LAST:event_jTable1FocusLost

    private void jBtnAtualizaTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAtualizaTotalActionPerformed
        if (jTable1.getRowCount() > 0 && ((String) jTable1.getValueAt(0, 4) != null)) {
            Double total = 0.0;
            for (int i = 0; i < jTable1.getRowCount(); i++) {
                total = total + FormataDinheiro.moneyForCalc((String) jTable1.getValueAt(i, 4));
            }
            if(total > 0)
                jTVlrNota.setText(FormataDinheiro.moneyForApp(total));
            //System.out.println("existe linha com valor");
        }
    }//GEN-LAST:event_jBtnAtualizaTotalActionPerformed

    public static JTable getjTable1() {
        return jTable1;
    }

    public static JTextField getjTVlrNota() {
        return jTVlrNota;
    }
    
    

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
            java.util.logging.Logger.getLogger(TelaNotaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNotaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNotaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNotaEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaNotaEntrada dialog = new TelaNotaEntrada(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAdd;
    private javax.swing.JButton jBtnApagaTudo;
    private javax.swing.JButton jBtnAtualizaTotal;
    private javax.swing.JButton jBtnExclui;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JButton jBtnSair;
    private javax.swing.JButton jBtnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTCidade;
    private javax.swing.JFormattedTextField jTCnpj;
    private javax.swing.JTextField jTNumNota;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTQuantProduto;
    private javax.swing.JTextField jTRazaoSocial;
    private javax.swing.JTextField jTUF;
    private static javax.swing.JTextField jTVlrNota;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
