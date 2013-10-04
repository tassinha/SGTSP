/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Aula;
import Entidades.Professor;
import EnviarEmail.MailTester;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ge
 */
@WebServlet(name = "Troca", urlPatterns = {"/site/Troca"})
public class Troca extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, UnsupportedEncodingException {

        EntityManager conecta = Persistence.createEntityManagerFactory("SGTSPFinalPU").createEntityManager();
        String horario = (String) request.getSession().getAttribute("horario");
        Professor professor = (Professor) request.getSession().getAttribute("ProfessorLogado");
        String hora1;
        String hora2;
        String hora3;
        String hora4;
        String hora5;
        List<Long> ids;
        if (horario.length() == 11) {
            hora1 = horario.substring(0, 3);
            hora2 = horario.substring(4, 7);
            hora3 = horario.substring(8, 11);
            hora4 = horario.substring(0, 7);
            hora5 = horario.substring(4, 11);
            ids = new Dao.DAO(conecta).seleciona("SELECT DISTINCT a.professor.id FROM Aula a WHERE a.hora = '" + horario + "' OR a.hora = '" + hora1 + "' OR a.hora = '" + hora2 + "' OR a.hora = '" + hora3 + "' OR a.hora = '" + hora4 + "' OR a.hora = '" + hora5 + "' OR a.professor.id =" + professor.getId());
        } else if (horario.length() == 7) {
            hora1 = horario.substring(0, 3);
            hora2 = horario.substring(4, 7);
            ids = new Dao.DAO(conecta).seleciona("SELECT DISTINCT a.professor.id FROM Aula a WHERE a.hora = '" + horario + "' OR a.hora = '" + hora1 + "' OR a.hora = '" + hora2 + "' OR a.id =" + professor.getId());
        } else {
            ids = new Dao.DAO(conecta).seleciona("SELECT DISTINCT a.professor.id FROM Aula a WHERE a.hora = '" + horario + "' OR a.id =" + professor.getId());

        }
        List<String> email = new ArrayList<String>();
        List<Aula> aulas = new Dao.DAO(conecta).seleciona("SELECT a FROM Aula a");
        List<String> emailok = new ArrayList<String>();

        if (horario.length() == 11) {
            for (Aula aula : aulas) {
                if (aula.getHora().length() == 11) {
                    emailok.add(aula.getProfessor().getEmail());
                }
            }
        } else if (horario.length() == 7) {
            for (Aula aula : aulas) {
                if (aula.getHora().length() == 7) {
                    emailok.add(aula.getProfessor().getEmail());
                }
            }
        }else{
            for (Aula aula : aulas) {
                if (aula.getHora().length() == 3) {
                    emailok.add(aula.getProfessor().getEmail());
                }
            }
        }

        List<String> novaLista = new ArrayList(new HashSet(emailok)); 

        for (Long long1 : ids) {

            email.add((String) new Dao.DAO(conecta).selecionaEspecifico("SELECT p.email FROM Professor p WHERE p.id=" + long1));

        }

        for (int i = 0; i < email.size(); i++) {
            for (int j = 0; j < novaLista.size(); j++) {
                if (email.get(i).equals(novaLista.get(j))) {
                    novaLista.remove(j);
                }
            }
        }

        Map<String, String> map = new HashMap<String, String>();
        for (String string : novaLista) {
            map.put(string, "");
            System.out.println(string);
        }
        try {
            MailTester.enviarEmail(map, "Troca de aula solicitada pelo professor "+professor.getNome(), "Troca de Aula");
        } catch (MessagingException ex) {
            Logger.getLogger(Troca.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("principal.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
