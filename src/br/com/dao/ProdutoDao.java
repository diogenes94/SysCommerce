/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Conect;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogenes
 */
public class ProdutoDao {
    
    public void inserirProduto(String descricao,String quantidade,String gramatura,String preco,String ativo,
            String dataCadastro,String dataAlteracao,String usuariosId,String precoCusto){
        
        String query = "insert into produto"
                + "(Descricao,Quantidade,Gramatura,Preco,Ativo,Data_Cadastro,Data_Alteracao,Usuarios_id,Preco_Custo) "
                + " values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, descricao);
            stmt.setString(2, quantidade);
            stmt.setString(3, gramatura);
            stmt.setString(4, preco);
            stmt.setString(5, ativo);
            stmt.setString(6, dataCadastro);
            stmt.setString(7, dataAlteracao);
            stmt.setString(8, usuariosId);
            stmt.setString(9, precoCusto);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
