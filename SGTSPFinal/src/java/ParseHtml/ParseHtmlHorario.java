/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ParseHtml;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author Ge
 */
public class ParseHtmlHorario {
    public Map Parse(String html) throws IOException {
        File file = new File(html);
        Map horarioSemanal = new TreeMap<String, String>();
        Document doc = Jsoup.parse(file, "ISO-8859-1");

        horarioSemanal.putAll(selectTurno("m", doc));
        horarioSemanal.putAll(selectTurno("t", doc));
        horarioSemanal.putAll(selectTurno("n", doc));

        return horarioSemanal;
    }
    public Map Parse(File arquivo) throws IOException {
       
        Map horarioSemanal = new TreeMap<String, String>();
        Document doc = Jsoup.parse(arquivo, "ISO-8859-1");

        horarioSemanal.putAll(selectTurno("m", doc));
        horarioSemanal.putAll(selectTurno("t", doc));
        horarioSemanal.putAll(selectTurno("n", doc));

        return horarioSemanal;
    }

    private Map selectTurno(String turno, Document doc) {
        int diaSemana, aula;
        TreeMap horario = new TreeMap<String, String>();
        for (diaSemana = 2; diaSemana < 8; diaSemana++) {
            for (aula = 1; aula < 7; aula++) {
                
                String diaTurnoAula =  diaSemana + turno + aula;
                String tagId = "dv_" + diaTurnoAula;
                
                
                Element element = doc.getElementById(tagId);
                if (element != null) {
                    horario.put(diaTurnoAula, element.text());
                }
            }
        }
        return horario;
    }
}
