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
public class FornecedorDao {

    public void InserirFornecedor(String razaoSocial, String nomeFantasia, String cnpj, String ie, String endereco, String numero,
            String bairro, String cidade, String estado, String telefone, String fax, String im, String cep, String dataCadastro,
            String dataAlteracao, String usuariosId, String Email, String ativo, String complemento) {

        String query = "insert into fornecedor (Razao_Social,Nome_Fantasia,CNPJ,IE,Endereco,Numero,Bairro,Cidade,Estado,Telefone,"
                + "Fax,IM,CEP,Data_Cadastro,Data_Alteracao,Usuarios_id,Ativo,Email,complemento) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; // 19 parametros
        PreparedStatement stmt;
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, razaoSocial);
            stmt.setString(2, nomeFantasia);
            stmt.setString(3, cnpj);
            stmt.setString(4, ie);
            stmt.setString(5, endereco);
            stmt.setString(6, numero);
            stmt.setString(7, bairro);
            stmt.setString(8, cidade);
            stmt.setString(9, estado);
            stmt.setString(10, telefone);
            stmt.setString(11, fax);
            stmt.setString(12, im);
            stmt.setString(13, cep);
            stmt.setString(14, dataCadastro);
            stmt.setString(15, dataAlteracao);
            stmt.setString(16, usuariosId);
            stmt.setString(18, ativo);
            stmt.setString(17, Email);
            stmt.setString(19, complemento);
            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet pesquisaFornecedor(String razaoSocial, String id) {
        String query = "SELECT f.*, u.* FROM fornecedor f inner join usuarios u on (f.Usuarios_id = u.id) where f.Razao_Social like ? or f.id like ? ";
        PreparedStatement stmt;
        ResultSet rs = null;
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, razaoSocial);
            stmt.setString(2, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public ResultSet pesquisaFornecedorId(String id) {
        String query = "SELECT f.*, u.* FROM fornecedor f inner join usuarios u on (f.Usuarios_id = u.id) where f.id like ? ";
        PreparedStatement stmt;
        ResultSet rs = null;
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, id);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void atualizaFornecedor(String razaoSocial, String nomeFantasia, String cnpj, String ie, String endereco, String numero,
            String bairro, String cidade, String estado, String telefone, String fax, String im, String cep,
            String dataAlteracao, String usuariosId, String Email, String ativo, String complemento ,String id) {
        PreparedStatement stmt;
        String query = "update fornecedor set Razao_Social = ?, Nome_Fantasia = ?, CNPJ = ?, IE = ?, Endereco = ?,"
                + "Numero = ?, Bairro = ?, Cidade = ?, Estado = ?, Telefone = ?, Fax = ?, IM = ?, CEP = ?,"
                + "Data_Alteracao = ?, Usuarios_id = ?, Ativo = ?, Email = ?, complemento = ? where id = ? ";
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, razaoSocial);
            stmt.setString(2, nomeFantasia);
            stmt.setString(3, cnpj);
            stmt.setString(4, ie);
            stmt.setString(5, endereco);
            stmt.setString(6, numero);
            stmt.setString(7, bairro);
            stmt.setString(8, cidade);
            stmt.setString(9, estado);
            stmt.setString(10, telefone);
            stmt.setString(11, fax);
            stmt.setString(12, im);
            stmt.setString(13, cep);
            stmt.setString(14, dataAlteracao);
            stmt.setString(15, usuariosId);
            stmt.setString(17, ativo);
            stmt.setString(16, Email);
            stmt.setString(18, complemento);
            stmt.setString(19, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FornecedorDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        FornecedorDao forn = new FornecedorDao();
        try {
            forn.atualizaFornecedor(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,null);
        } catch (Exception e) {
            System.out.println("xiiiii fudeu.. kkkkk");
        }
        
        
    }

}
