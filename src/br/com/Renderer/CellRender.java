/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Renderer;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author diogenes.francisco
 */
public class CellRender extends DefaultTableCellRenderer {

    public CellRender() {
        super();
        // setOpaque(true); 
    }
    Color corAmarelo = Color.decode("#CCCC7A");
    //Color corAmareloClaro = new Color(255, 255, 153);#CDCD00
    Color corAmareloClaro = Color.decode("#FFFFB8");
    Color corVermelho = new Color(255, 153, 153);//Color.decode("#FF4040");
    Color corVermelho2 = Color.decode("#FF4040");
    Color AzulClaro = Color.decode("#87CEFF");
    Color Azul = Color.decode("#6CA6CD");
    Color Cinza = Color.decode("#CDC9C9");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            //Alinha conteúdo a direita

        if (column == 0) {
            setHorizontalAlignment(SwingConstants.CENTER);
        } else if(column == 2 || column == 3 || column == 4){
            this.setHorizontalAlignment(RIGHT);
        }else{
            setHorizontalAlignment(LEFT);
        }
            //Colore Tabela
                /*if ((row % 2)==0){  
         setBackground(Color.LIGHT_GRAY);  
         setForeground(Color.BLACK); 
                
         } else*/
        //setForeground(Color.BLACK);

//        if ((column == 14 || column == 13 || column == 26 || column == 27 || column == 36|| column == 40 )) {
//            if ((row % 2) == 0) {
//                setBackground(corVermelho);
//            } else {
//                setBackground(corVermelho2);
//            }
//        } else if (column >= 2 && column <= 12) {
//            if ((row % 2) == 0) {
//                setBackground(corAmareloClaro);
//            } else {
//                setBackground(corAmarelo);
//            }
//            // setBackground(corAmarelo);  
//        } else if (column >= 15 && column <= 25 || column >= 28 && column <= 31 || column == 41 || column == 42 ) {
//            if ((row % 2) == 0) {
//                setBackground(AzulClaro);
//            } else {
//                setBackground(Azul);
//            }
//                    //setBackground(Color.BLUE);
//            // setForeground(Color.WHITE);
//        } else if (column <= 2 || column >= 28) {
//
//            if ((row % 2) == 0) {
//                setBackground(Color.WHITE);
//            } else {
//                setBackground(Cinza);
//            }
//
//        }
//        if (value == null) {
//            setText("");
//        } else {
//            setText(value.toString());
//        }
//        if (column < 2) {
//            if ((() table.getModel()).getValueAt(row, 59).toString().equals("S")) {
//               setBackground(Color.GREEN);
//            }
//
//        }
        //return this;  
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);  
        //return comp;
    }

    /*public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
     if ((row % 2)==0){  
     setBackground(Color.LIGHT_GRAY);  
     setForeground(Color.BLACK); 
            
     } else {  
     setBackground(Color.WHITE);  
     setForeground(Color.BLACK);  
     }  
     if (value==null){  
     setText("");  
     } else {  
     setText(value.toString());  
     }  
        
     return this;  
        
     } */
}
