/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils;

/**
 *
 * @author diogenes.francisco
 */
public class InsereMascara {
    
    public static String insereMascCpf(String cpf){
        String formt = cpf.substring(0,3)+"."+cpf.substring(3,6)+"."+cpf.substring(6,9)+"-"+cpf.substring(9,11);
        return formt;
    }
    
    public static String insereMascCnpj(String cnpj){
        String formt = cnpj.substring(0,2)+"."+cnpj.substring(2,5)+"."+cnpj.substring(5,8)+"/"+cnpj.substring(8,12)+"-"+cnpj.substring(12,14);
        return formt;
    }
}
