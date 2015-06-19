/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Conect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diogenes.francisco
 */
public class NotaEntradaDao {
    
    
    /**Métodos de busca e validação
     ---- Validação se existe nota fiscal já lançada para aquele fornecedor anteriormente
     * @param idFor
     * @param numNota
     * @return  **/
    public ResultSet validaNfExiste(String idFor,String numNota){
        ResultSet rs = null;
        String query = "select fp.*, f.* from fornecedor_produto fp inner join fornecedor f on (fp.Fornecedor_id = f.id ) where f.id = ? and Num_Nota = ?";
        PreparedStatement stmt;
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, idFor);
            stmt.setString(2, numNota);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(NotaEntradaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
}
