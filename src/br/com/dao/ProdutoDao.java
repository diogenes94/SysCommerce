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
 * @author Diogenes
 */
public class ProdutoDao {
    
    public Boolean inserirProduto(String descricao,String quantidade,String gramatura,String preco,String ativo,
            String dataCadastro,String dataAlteracao,String usuariosId,String precoCusto,String qntMinima){
        
        String query = "insert into produto"
                + "(Descricao,Quantidade,Gramatura,Preco,Ativo,Data_Cadastro,Data_Alteracao,Usuarios_id,Preco_Custo,qntMinima) "
                + " values (?,?,?,?,?,?,?,?,?,?)";
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
            stmt.setString(10, qntMinima);
            return stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    public ResultSet pesquisaProduto(String id,String descricao){
        PreparedStatement stmt;
        ResultSet rs = null;
        String query = "select p.* , u.* from produto p inner join usuarios u on (p.usuarios_id = u.id) where descricao like ? or p.id like ? ";
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, descricao);
            stmt.setString(2, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet pesquisaProdutoId(String id){
        PreparedStatement stmt;
        ResultSet rs = null;
        String query = "select p.* , u.* from produto p inner join usuarios u on (p.usuarios_id = u.id) where p.id = ?";
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void atualizaProduto(String descricao,String quantidade,String gramatura,String preco,String ativo,
            String dataAlteracao,String usuariosId,String precoCusto,String qntMinima,String id){
        String query = "update produto  set Descricao = ?,Quantidade = ?,Gramatura = ?,Preco = ?,Ativo = ?,Data_Alteracao = ?,Usuarios_id = ?,Preco_Custo = ?,qntMinima = ? where id = ?";
        PreparedStatement stmt;
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, descricao);
            stmt.setString(2, quantidade);
            stmt.setString(3, gramatura);
            stmt.setString(4, preco);
            stmt.setString(5, ativo);
            stmt.setString(6, dataAlteracao);
            stmt.setString(7, usuariosId);
            stmt.setString(8, precoCusto);
            stmt.setString(9, qntMinima);
            stmt.setString(10, id);
            stmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*public static void main(String[] args) {
        ProdutoDao p = new ProdutoDao();
        ResultSet rs = p.pesquisaProduto("", "%%");
        try {
            while (rs.next()){
                rs.getString("descricao");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
}
