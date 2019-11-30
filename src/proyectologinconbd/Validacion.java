/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectologinconbd;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class Validacion {
    public void validarLetras(JTextField texto){
        texto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                int i=(int)e.getKeyChar();//prohibe caracteres, 64 es arroba
                if(!Character.isLetter(c) || i==64){
                    e.consume();
                }
            }
        });
    }
    public void validarNumeros(JTextField texto){
        texto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                if(!Character.isDigit(c)){
                    e.consume();
                }
            }
        });
    }
    public void limitarCaracteres(JTextField texto, int cantidad){
        texto.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                char c=e.getKeyChar();
                int tam=texto.getText().length();
                if(tam>=cantidad){
                    e.consume();
                }
            }
        });
    }
    
}
