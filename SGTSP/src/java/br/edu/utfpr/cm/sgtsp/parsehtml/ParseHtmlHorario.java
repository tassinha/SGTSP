/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.sgtsp.parsehtml;

import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author wenner
 */
public class ParseHtmlHorario {

    File file;

    public ParseHtmlHorario(String html) {
        File file = new File(html);
    }

    public String Parse() throws IOException {
        String horarioSemanal = "";
        Document doc = Jsoup.parse(this.file, "ISO-8859-1");

        horarioSemanal = selectTurno("m", doc);
        horarioSemanal += selectTurno("t", doc);
        horarioSemanal += selectTurno("n", doc);

        return horarioSemanal;
    }

    private String selectTurno(String turno, Document doc) {
        String horario = "";
        int diaSemana, aula;
        for (diaSemana = 2; diaSemana < 8; diaSemana++) {
            for (aula = 1; aula < 7; aula++) {
                String tagId = "dv_" + diaSemana + turno + aula;
                Element element = doc.getElementById(tagId);
                if (element != null) {
                    horario =element.text();
                }
            }
        }
        return horario;
    }
    
}