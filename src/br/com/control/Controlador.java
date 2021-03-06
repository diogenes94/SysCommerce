/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.control;

import br.com.dao.ClienteDao;
import br.com.dao.FornecedorDao;
import br.com.dao.NotaEntradaDao;
import br.com.dao.ProdutoDao;
import java.sql.ResultSet;

/**
 *
 * @author Diogenes
 */
public class Controlador {

    ClienteDao cli;
    FornecedorDao forn;
    ProdutoDao prod;
    NotaEntradaDao nfIn;

    // CLIENTE
    public void inserirCliente(String nome, String cpf, String rg, String dataNasc, String sexo,
            String contato, String contato2, String observacao, String dataCadastro, String ativo, String naturalidade,
            String email, String usuariosId, String dataAlteracao, String cnpj, String tipoCliente, String endereco,
            String numero, String complemento, String cidade, String estado, String bairro, String nomeFantasia, String ie, String cep) {
        cli = new ClienteDao();
        cli.inserirCliente(nome, cpf, rg, dataNasc, sexo, contato, contato2, observacao, dataCadastro, ativo, naturalidade,
                email, usuariosId, dataAlteracao, cnpj, tipoCliente, endereco, numero, complemento, cidade, estado, bairro,
                nomeFantasia, ie, cep);

    }

    /**
     * Methods of search client*
     */
    public ResultSet pesquisaCliente(String nome, String codigo) {
        cli = new ClienteDao();
        ResultSet rs = cli.pesquisaCliente(nome, codigo);
        return rs;
    }

    public ResultSet pesquisaClienteId(String codigo) {
        cli = new ClienteDao();
        ResultSet rs = cli.pesquisaClienteId(codigo);
        return rs;
    }

    public void atualizaCliente(String nome, String cpf, String rg, String dataNasc, String sexo,
            String contato, String contato2, String observacao, String ativo, String naturalidade,
            String email, String usuariosId, String dataAlteracao, String cnpj, String tipoCliente, String endereco,
            String numero, String complemento, String cidade, String estado, String bairro, String nomeFantasia, String ie, String cep, String id) {

        cli = new ClienteDao();
        cli.atualizaCliente(nome, cpf, rg, dataNasc, sexo, contato, contato2, observacao, ativo, naturalidade, email, usuariosId,
                dataAlteracao, cnpj, tipoCliente, endereco, numero, complemento, cidade, estado, bairro, nomeFantasia, ie, cep, id);

    }

    // FORNECEDOR
    public void InserirFornecedor(String razaoSocial, String nomeFantasia, String cnpj, String ie, String endereco, String numero,
            String bairro, String cidade, String estado, String telefone, String fax, String im, String cep, String dataCadastro,
            String dataAlteracao, String usuariosId, String Email, String ativo, String complemento) {
        forn = new FornecedorDao();
        forn.InserirFornecedor(razaoSocial, nomeFantasia, cnpj, ie, endereco, numero, bairro, cidade, estado, telefone, fax, im, cep,
                dataCadastro, dataAlteracao, usuariosId, Email, ativo, complemento);
    }

    public ResultSet pesquisaFornecedor(String id, String razaoSocial) {
        forn = new FornecedorDao();
        ResultSet rs = forn.pesquisaFornecedor(id, razaoSocial);
        return rs;
    }

    public ResultSet pesquisaFornecedorId(String id) {
        forn = new FornecedorDao();
        ResultSet rs = forn.pesquisaFornecedorId(id);
        return rs;
    }

    public void atualizaFornecedor(String razaoSocial, String nomeFantasia, String cnpj, String ie, String endereco, String numero,
            String bairro, String cidade, String estado, String telefone, String fax, String im, String cep,
            String dataAlteracao, String usuariosId, String Email, String ativo, String complemento, String id) {
        forn = new FornecedorDao();
        forn.atualizaFornecedor(razaoSocial, nomeFantasia, cnpj, ie, endereco, numero, bairro, cidade, estado,
                telefone, fax, im, cep, dataAlteracao, usuariosId, Email, ativo, complemento, id);
    }

    //PRODUTO
    public Boolean inserirProduto(String descricao, String quantidade, String gramatura, String preco, String ativo,
            String dataCadastro, String dataAlteracao, String usuariosId, String precoCusto, String qntMinima) {
        prod = new ProdutoDao();
        return prod.inserirProduto(descricao, quantidade, gramatura, preco, ativo, dataCadastro, dataAlteracao, usuariosId, precoCusto, qntMinima);
    }

    public ResultSet pesquisaProduto(String id, String descricao) {
        prod = new ProdutoDao();
        ResultSet rs = prod.pesquisaProduto(id, descricao);
        return rs;
    }

    public ResultSet pesquisaProdutoId(String id) {
        prod = new ProdutoDao();
        ResultSet rs = prod.pesquisaProdutoId(id);
        return rs;
    }

    public void atualizaProduto(String descricao, String quantidade, String gramatura, String preco, String ativo,
            String dataAlteracao, String usuariosId, String precoCusto, String qntMinima, String id) {
        prod = new ProdutoDao();
        prod.atualizaProduto(descricao, quantidade, gramatura, preco, ativo, dataAlteracao, usuariosId, precoCusto, qntMinima, id);
    }

    //Nota entrada
    public ResultSet validaNfExiste(String idFor, String numNota) {
        nfIn = new NotaEntradaDao();
        ResultSet rs = nfIn.validaNfExiste(idFor, numNota);
        return rs;
    }
}
