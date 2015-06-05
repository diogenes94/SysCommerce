/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils;

import java.awt.Dialog;
import javax.swing.JOptionPane;
import org.joda.time.LocalDate;

/**
 *
 * @author Diogenes
 */
public class ValidaData {
    public static Boolean validaData(String data){
        Integer dia = Integer.parseInt(data.substring(0,2));
        Integer mes = Integer.parseInt(data.substring(3,5));
        Integer ano = Integer.parseInt(data.substring(6,10));        
        try {
            LocalDate date = new LocalDate(ano, mes, dia);
        } catch (Exception e) {
            return false;
        }
        //System.out.println(date);
        return true;
    }
    
//    public static void main(String[] args) {
//        boolean valida =   ValidaData.validaData("30/02/2014");
//        System.out.println(valida);
//    }
}
