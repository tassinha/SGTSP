/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

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
        System.out.println(horario);
        String[] vetor = horario.split(" ");
        List<String> email = new ArrayList<String>();
        List<Long> ids = new Dao.DAO(conecta).seleciona("SELECT DISTINCT a.professor.id FROM Aula a WHERE a.hora != '" + horario + "' AND a.hora != '"+vetor[0]+"' AND a.hora != '"+vetor[1]+"' AND a.hora != '"+vetor[2]+"'");
        for (Long id : ids) {
            email.add((String) new Dao.DAO(conecta).selecionaEspecifico("SELECT p.email FROM Professor p WHERE p.id=" + id));
        }
        for (String string : email) {
            System.out.println(string);
        }
        response.sendRedirect("principal.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
