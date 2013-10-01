/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ge
 */
@WebServlet(name = "FazerLogout", urlPatterns = {"/FazerLogout"})
public class FazerLogout extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
            request.getSession().removeAttribute("ProfessorLogado");
            request.getSession().removeAttribute("Professor");
            request.getSession().removeAttribute("erroLogin");
            request.getSession().removeAttribute("aulas");
            response.sendRedirect("index.jsp");
        
    }
    
}
