/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tabelas;

import br.com.model.ClienteModel;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author diogenes.francisco
 */
public class TabelaBuscaCliente extends AbstractTableModel{
    //nome da coluna da table
    private final String[] colunas = new String[]{"Código", "Nome", "CPF/CNPJ","Ativo"};
    //lista para a manipulacao do objeto
    private List<ClienteModel> listaRegistro;

    public List<ClienteModel> getListaRegistro() {
        return listaRegistro;
    }
    
    public void addLinha(ClienteModel registro){
        this.listaRegistro.add(registro);
        this.fireTableDataChanged();
    }
    
    public void removeLinhas(){
        this.listaRegistro.clear();
        fireTableDataChanged();
    }
    
    public void removeRow(int linha){
            this.listaRegistro.remove(linha);
            this.fireTableRowsDeleted(linha, linha);
    }
    
    public TabelaBuscaCliente() {
        listaRegistro = new LinkedList<ClienteModel>();
    }

    public TabelaBuscaCliente(List<ClienteModel> listaRegistro) {
        this.listaRegistro = listaRegistro;
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
        ClienteModel f = listaRegistro.get(rowIndex);
        switch(columnIndex){
            case 0:
                return f.getId();
            case 1:
                return f.getNome();
            case 2:
                return f.getCpf();
            case 3:
                return f.getAtivo();
            default:
                return null;
        }
    }
    
    @Override
    public void setValueAt(Object valor, int linha, int coluna){
        if( valor == null) {
            return;
        }
        
       
        /*switch(coluna){
            
            case 6:  listaRegistro.get(linha).setCheckboxE((Boolean) valor );break;
            case 7:  listaRegistro.get(linha).setCheckboxS((Boolean) valor );break;
        }*/ 
        this.fireTableRowsUpdated(linha, linha);
    }
    
    //determina o nome das colunas
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    //determina que tipo de objeto cada coluna irÃ¡ suportar
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return int.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Boolean.class;
            default:
                return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    
    public void limpaTabela(){
        this.listaRegistro.clear();
        fireTableDataChanged();
    }
}
