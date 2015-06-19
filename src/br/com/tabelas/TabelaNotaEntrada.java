/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tabelas;

import br.com.ViewAux.BuscaProduto;
import br.com.control.Controlador;
import br.com.model.ProdutoModel;
import br.com.utils.FormataDinheiro;
import br.com.view.TelaNotaEntrada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diogenes.francisco
 */
public class TabelaNotaEntrada extends AbstractTableModel {

    TelaNotaEntrada tela;
    //nome da coluna da table
    private final String[] colunas = new String[]{"Código", "Descrição", "Quantidade", "Preço", "Preço Total"};
    //lista para a manipulacao do objeto
    private List<ProdutoModel> listaRegistro;

    public List<ProdutoModel> getListaRegistro() {
        return listaRegistro;
    }

    public void addLinha(ProdutoModel registro) {
        this.listaRegistro.add(registro);
        this.fireTableDataChanged();
    }

    public void removeLinhas() {
        this.listaRegistro.clear();
        fireTableDataChanged();
    }

    public void removeRow(int linha) {
        this.listaRegistro.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }

    public TabelaNotaEntrada() {
        listaRegistro = new LinkedList<ProdutoModel>();
    }

    public TabelaNotaEntrada(List<ProdutoModel> listaRegistro) {
        this.listaRegistro = listaRegistro;
    }

    public TabelaNotaEntrada(List<ProdutoModel> listaRegistro, TelaNotaEntrada tela) {
        this.listaRegistro = listaRegistro;
        this.tela = tela;
    }

    //numero de linhas
    @Override
    public int getRowCount() {
        return listaRegistro.size();
    }

    //numero de colunas
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    //define o que cada coluna conterÃ¡ do objeto
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ProdutoModel f = listaRegistro.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return f.getId();
            case 1:
                return f.getDescricao();
            case 2:
                return f.getQuantidade();
            case 3:
                return f.getPrecoCusto();
            case 4:
                return f.getVlrTotal();
            default:
                return null;
        }
    }

    @Override
    public void setValueAt(Object valor, int linha, int coluna) {
        if (valor == null) {
            return;
        }
        switch (coluna) {
            case 0:
                listaRegistro.get(linha).setId((String) valor);
                valor = null;
            case 2:
                listaRegistro.get(linha).setQuantidade((String) valor);
                valor = null;
            case 3:
                listaRegistro.get(linha).setPrecoCusto((String) valor);
                valor = null;
            case 4:
                listaRegistro.get(linha).setVlrTotal((String) valor);

        }
        fireTableCellUpdated(linha, coluna);
    }

    //determina o nome das colunas
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    //determina que tipo de objeto cada coluna irÃ¡ suportar
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            default:
                return null;
        }
    }

    @Override
    public void fireTableCellUpdated(int row, int column) {
        if (column == 0) {
            Controlador c = new Controlador();
            ResultSet rsDesc = c.pesquisaProdutoId(listaRegistro.get(row).getId());
            ResultSet rs = c.pesquisaProduto(listaRegistro.get(row).getId(), "%" + listaRegistro.get(row).getId() + "%");
            try {
                if (rsDesc.last() && rsDesc.getRow() == 1) {
                    rsDesc.first();
                    if (rsDesc.getBoolean("ativo")) {
                        listaRegistro.get(row).setDescricao(rsDesc.getString("descricao"));
                        listaRegistro.get(row).setId(rsDesc.getString("id"));
                    }else{
                        JOptionPane.showMessageDialog(tela, "Produto inativo, indisponível para venda!","ERRO",JOptionPane.ERROR_MESSAGE);
                        listaRegistro.get(row).setId(null);
                        return;
                    }
                } else if (rs.last() && rs.getRow() == 1) {
                    rs.first();
                    listaRegistro.get(row).setDescricao(rs.getString("descricao"));
                    listaRegistro.get(row).setId(rs.getString("id"));
                } else {
                    new BuscaProduto(null, true, listaRegistro.get(row).getId(), tela).setVisible(true);
                }
            } catch (SQLException ex) {
                Logger.getLogger(TabelaNotaEntrada.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (column == 2) {
            Double quant = Double.parseDouble(listaRegistro.get(row).getQuantidade().replaceAll("[,]", "."));
            listaRegistro.get(row).setQuantidade(FormataDinheiro.moneyForApp(quant));
        } else if (column == 3) {

            Double quant = Double.parseDouble(listaRegistro.get(row).getQuantidade().replaceAll("[,]", "."));
            Double preco = Double.parseDouble(listaRegistro.get(row).getPrecoCusto().replaceAll("[,]", "."));
            Double total = preco * quant;

            listaRegistro.get(row).setQuantidade(FormataDinheiro.moneyForApp(quant));
            listaRegistro.get(row).setVlrTotal(FormataDinheiro.moneyForApp(total));
            listaRegistro.get(row).setPrecoCusto(FormataDinheiro.moneyForApp(preco));
        }

        super.fireTableCellUpdated(row, column); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 0 || columnIndex == 2 || columnIndex == 3 || columnIndex == 4) {
            return true;
        }

        return false;
    }

    public void limpaTabela() {
        this.listaRegistro.clear();
        fireTableDataChanged();
    }

}
