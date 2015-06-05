/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import br.com.dao.ClienteDao;
import java.sql.ResultSet;

/**
 *
 * @author Diogenes
 */
public class Controlador {
    ClienteDao cli;
    
    public void inserirCliente(String nome, String cpf, String rg, String dataNasc, String sexo,
            String contato, String contato2, String observacao, String dataCadastro, String ativo, String naturalidade,
            String email, String usuariosId, String dataAlteracao, String cnpj, String tipoCliente, String endereco,
            String numero, String complemento, String cidade, String estado, String bairro,String nomeFantasia, String ie, String cep){
        cli = new ClienteDao();
        cli.inserirCliente(nome, cpf, rg, dataNasc, sexo, contato, contato2, observacao, dataCadastro, ativo, naturalidade, 
                email, usuariosId, dataAlteracao, cnpj, tipoCliente, endereco, numero, complemento, cidade, estado, bairro, 
                nomeFantasia, ie, cep);
        
    }
    
    /** Methods of search client**/
    public ResultSet pesquisaCliente(String nome,String codigo){
        cli = new ClienteDao();
        ResultSet rs = cli.pesquisaCliente(nome, codigo);
        return rs;
    }
    
    public ResultSet pesquisaClienteNome(String nome){
        cli = new ClienteDao();
        ResultSet rs = cli.pesquisaClienteNome(nome);
        return rs;
    }
    
    public ResultSet pesquisaClienteId(String codigo){
        cli = new ClienteDao();
        ResultSet rs = cli.pesquisaClienteId(codigo);
        return rs;
    }
    
    public void atualizaCliente(String nome, String cpf, String rg, String dataNasc, String sexo,
            String contato, String contato2, String observacao, String ativo, String naturalidade,
            String email, String usuariosId, String dataAlteracao, String cnpj, String tipoCliente, String endereco,
            String numero, String complemento, String cidade, String estado, String bairro, String nomeFantasia, String ie,String cep, String id){
        
        cli = new ClienteDao();
        cli.atualizaCliente(nome, cpf, rg, dataNasc, sexo, contato, contato2, observacao, ativo, naturalidade, email, usuariosId, 
                dataAlteracao, cnpj, tipoCliente, endereco, numero, complemento, cidade, estado, bairro, nomeFantasia, ie,cep, id);
        
    }
    
}
