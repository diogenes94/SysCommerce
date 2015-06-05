/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.control.Conect;
import br.com.utils.InsereMascara;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diogenes
 */
public class ClienteDao {

    /**
     * Métodos de inserção de Cliente
     *
     *
     * @param nome
     * @param cpf
     * @param rg
     * @param dataNasc
     * @param sexo
     * @param contato
     * @param contato2
     * @param observacao
     * @param dataCadastro
     * @param ativo
     * @param email
     * @param naturalidade
     * @param tipoCliente
     * @param endereco
     * @param usuariosId
     * @param dataAlteracao
     * @param cnpj
     * @param numero
     * @param cidade
     * @param complemento
     * @param estado
     * @param bairro
     * @param nomeFantasia
     * @param ie
     */
    public void inserirCliente(String nome, String cpf, String rg, String dataNasc, String sexo,
            String contato, String contato2, String observacao, String dataCadastro, String ativo, String naturalidade,
            String email, String usuariosId, String dataAlteracao, String cnpj, String tipoCliente, String endereco,
            String numero, String complemento, String cidade, String estado, String bairro, String nomeFantasia, String ie, String cep) {

        PreparedStatement stmt = null;
        String query = "insert into Cliente (Nome,Cpf,Rg,Data_Nasc,Sexo,Contato,Contato2,Observacao,Data_Cadastro,"
                + "Ativo,Naturalidade,Email,Usuarios_id,Data_Alteracao,Cnpj,Tipo_Cliente,Endereco,Numero,\n"
                + "Complemento,Cidade,Estado,Bairro,nomeFantasia,ie,cep) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        //String query1 = "insert into Cliente (Nome,Usuarios_id) values (?,?)";
        try {
            //System.out.println(query);
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, rg);
            stmt.setString(4, dataNasc);
            stmt.setString(5, sexo);
            stmt.setString(6, contato);
            stmt.setString(7, contato2);
            stmt.setString(8, observacao);
            stmt.setString(9, dataCadastro);
            stmt.setString(10, ativo);
            stmt.setString(11, naturalidade);
            stmt.setString(12, email);
            stmt.setString(13, usuariosId);
            stmt.setString(14, dataAlteracao);
            stmt.setString(15, cnpj);
            stmt.setString(16, tipoCliente);
            stmt.setString(17, endereco);
            stmt.setString(18, numero);
            stmt.setString(19, complemento);
            stmt.setString(20, cidade);
            stmt.setString(21, estado);
            stmt.setString(22, bairro);
            stmt.setString(23, nomeFantasia);
            stmt.setString(24, ie);
            stmt.setString(25, cep);
            stmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaCliente(String nome, String cpf, String rg, String dataNasc, String sexo,
            String contato, String contato2, String observacao, String ativo, String naturalidade,
            String email, String usuariosId, String dataAlteracao, String cnpj, String tipoCliente, String endereco,
            String numero, String complemento, String cidade, String estado, String bairro, String nomeFantasia, String ie,String cep, String id) {
        PreparedStatement stmt = null;
        String query = "update cliente set  Nome = ?, Cpf = ?, Rg = ?, Data_Nasc = ?, Sexo = ?, Contato = ?, Contato2 = ?, "
                + "Observacao = ?, Ativo = ?, Naturalidade = ?, Email = ?, Usuarios_id = ?, "
                + "Data_Alteracao = ?, Cnpj = ?, Tipo_Cliente = ?, Endereco = ?, Numero = ?, Complemento = ?, "
                + "Cidade = ?, Estado = ?, Bairro = ?, nomeFantasia = ?, ie = ?, cep = ? where id = ? ";
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, rg);
            stmt.setString(4, dataNasc);
            stmt.setString(5, sexo);
            stmt.setString(6, contato);
            stmt.setString(7, contato2);
            stmt.setString(8, observacao);
            stmt.setString(9, ativo);
            stmt.setString(10, naturalidade);
            stmt.setString(11, email);
            stmt.setString(12, usuariosId);
            stmt.setString(13, dataAlteracao);
            stmt.setString(14, cnpj);
            stmt.setString(15, tipoCliente);
            stmt.setString(16, endereco);
            stmt.setString(17, numero);
            stmt.setString(18, complemento);
            stmt.setString(19, cidade);
            stmt.setString(20, estado);
            stmt.setString(21, bairro);
            stmt.setString(22, nomeFantasia);
            stmt.setString(23, ie);
            stmt.setString(24, cep);
            stmt.setString(25, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Busca Clientes por codigo ou id
     *
     * @param nome
     * @param codigo
     * @param nomem
     * @return
     */
    public ResultSet pesquisaCliente(String nome, String codigo) {
        ResultSet rs = null;
        PreparedStatement stmt;
        String query = "select c.* ,  u.Nome as nomeuser, u.Login from cliente c inner join usuarios u on (c.Usuarios_id = u.id) where c.Nome like ? or c.id like ? order by c.Nome";
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setString(2, codigo);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;

    }

    public ResultSet pesquisaClienteId(String codigo) {
        ResultSet rs = null;
        PreparedStatement stmt;
        String query = "select c.* ,  u.Nome as nomeuser, u.Login from cliente c inner join usuarios u on (c.Usuarios_id = u.id) where c.id like ? order by c.id";
        try {
            stmt = Conect.getConnection().prepareStatement(query);
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    /*public static void main(String[] args) {
     ClienteDao cli = new ClienteDao();
     ResultSet rs = cli.pesquisaCliente("", "11");
        
     try {
     while(rs.next()){ 
     System.out.println(InsereMascara.insereMascCpf(rs.getString("cpf")));
     }
            
     //cli.atualizaCliente("2015-05-19");
     } catch (SQLException ex) {
     Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
     }
     }*/
}
