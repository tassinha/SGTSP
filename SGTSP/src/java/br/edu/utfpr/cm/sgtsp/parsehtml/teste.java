/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.sgtsp.parsehtml;

import java.io.IOException;

/**
 *
 * @author henrique
 */
public class teste {
    public static void main(String[] args) throws IOException {
        ParseHtmlHorario p = new ParseHtmlHorario();
        String Parse = p.Parse("horario.html").toString();
        System.out.println(Parse);
    }
    
}
