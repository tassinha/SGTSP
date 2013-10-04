/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ge
 */
@WebServlet(name = "Solicitacao", urlPatterns = {"/site/Solicitacao"})
public class Solicitacao extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String solicitacao = request.getParameter("OPCAO");
        String horario = request.getParameter("horario");
        request.getSession().setAttribute("horario", horario);

        if (solicitacao == null) {
            request.getSession().setAttribute("mensagem", "Nenhuma opção foi selecionada!");
            response.sendRedirect("principal.jsp");
        } else if (solicitacao.equals("troca")) {
            response.sendRedirect("Troca");
        } else if (solicitacao.equals("substituicao")) {
            response.sendRedirect("Substituicao");
        } else {
            response.sendRedirect("Todos");
        }
    }
}
