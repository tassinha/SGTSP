/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Professor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Substituicao", urlPatterns = {"/site/Substituicao"})
public class Substituicao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
            ids = new Dao.DAO(conecta).seleciona("SELECT DISTINCT a.professor.id FROM Aula a WHERE a.hora = '" + horario + "' OR a.hora = '" + hora1 + "' OR a.hora = '" + hora2 + "' OR a.hora = '" + hora3 + "' OR a.hora = '" + hora4 + "' OR a.hora = '" + hora5 + "' OR a.professor.id ="+professor.getId());
        } else if (horario.length() == 7) {
            hora1 = horario.substring(0, 3);
            hora2 = horario.substring(4, 7);
            ids = new Dao.DAO(conecta).seleciona("SELECT DISTINCT a.professor.id FROM Aula a WHERE a.hora = '" + horario + "' OR a.hora = '" + hora1 + "' OR a.hora = '" + hora2 + "' OR a.id ="+professor.getId());
        } else {
            ids = new Dao.DAO(conecta).seleciona("SELECT DISTINCT a.professor.id FROM Aula a WHERE a.hora = '" + horario + "' OR a.id ="+professor.getId());

        }

        
        List<String> vetor = new Dao.DAO(conecta).seleciona("SELECT p.email FROM Professor p");
        List<String> email = new ArrayList<String>();
        
        for (Long long1 : ids) {
            email.add((String) new Dao.DAO(conecta).selecionaEspecifico("SELECT p.email FROM Professor p WHERE p.id="+long1));
        }
        
        for(int i = 0; i < email.size();i++){
            for(int j = 0; j < vetor.size();j++){
                if(email.get(i).equals(vetor.get(j))){
                    vetor.remove(j);
                }
            }
        }
        
        for (String string : vetor) {
            System.out.println(string);
        }
        
        //List<Long> ids = new Dao.DAO(conecta).seleciona("SELECT DISTINCT a.professor.id FROM Aula a WHERE a.hora = '"+ horario +"'");
        request.getSession().setAttribute("mensagem", null);
        response.sendRedirect("principal.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
