/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils;

/**
 *
 * @author Diogenes
 */
public class FormataData {
    
    public static String dateForBank(String date){
        String dia = date.substring(0,2);
        String mes = date.substring(3,5);
        String ano = date.substring(6,10);
        
        return ano+"-"+mes+"-"+dia;
    }
    public static  String dateForApp(String date){
        String dia = date.substring(8,10);
        String mes = date.substring(5,7);
        String ano = date.substring(0,4);
        return dia+"/"+mes+"/"+ano;
    }
    
}
