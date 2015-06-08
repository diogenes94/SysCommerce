/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.utils;

import java.util.Locale;

/**
 *
 * @author diogenes.francisco
 */
public class FormataDinheiro {

    public static String moneyForApp(Double valor) {
        String vlr = String.valueOf(String.format(Locale.US, "%.2f", valor));
        String decimal = vlr.substring(vlr.length() - 2, vlr.length());
        String vlrNotDecimal = vlr.substring(0, vlr.length()- 3);
        String formatado = "";
        Integer resto = vlrNotDecimal.length() % 3;
        
        if(resto == 1){
            vlrNotDecimal="00"+vlrNotDecimal;
        }else if (resto == 2){
            vlrNotDecimal = "0"+vlrNotDecimal;
        }
        for (int i = 0; i < vlrNotDecimal.length(); i = i+3) {
            formatado += vlrNotDecimal.substring(i, i+3);
            if(i<vlrNotDecimal.length() -3)
                formatado+=".";
        }
        while(formatado.substring(0,1).equals("0")){
            formatado = formatado.substring(1,formatado.length());
        }
        return formatado+","+decimal;
    }
}
