    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Diogenes
 */
public class ProdutoModel {
    String id,descricao,quantidade,gramatura,preco,dataCadastro,dataAlteracao,usuariosId,precoCusto;
    Boolean ativo;

    public ProdutoModel() {
    }

    public ProdutoModel(String id, String descricao, String preco, Boolean ativo) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.ativo = ativo;
    }

    public ProdutoModel(String id, String descricao, String quantidade, String gramatura, String preco, String dataCadastro, String dataAlteracao, String usuariosId, String precoCusto, Boolean ativo) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.gramatura = gramatura;
        this.preco = preco;
        this.dataCadastro = dataCadastro;
        this.dataAlteracao = dataAlteracao;
        this.usuariosId = usuariosId;
        this.precoCusto = precoCusto;
        this.ativo = ativo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getGramatura() {
        return gramatura;
    }

    public void setGramatura(String gramatura) {
        this.gramatura = gramatura;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(String dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getUsuariosId() {
        return usuariosId;
    }

    public void setUsuariosId(String usuariosId) {
        this.usuariosId = usuariosId;
    }

    public String getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(String precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    

    
    
    
    
}
