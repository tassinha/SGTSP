/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.sgtsp.login;

import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.sgtsp.ldap.LDAP;
import br.edu.utfpr.sgtsp.beans.Administrador;
import br.edu.utfpr.sgtsp.beans.Professor;
import br.edu.utfpr.sgtsp.daos.AdministradorDao;
import br.edu.utfpr.sgtsp.daos.ProfessorDao;
import br.edu.utfpr.sgtsp.daos.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authc.IncorrectCredentialsException;
import userLDAP.LoginLDAP;
import userLDAP.UserLDAP;

/**
 *
 * @author josimar
 */
public class LoginManager extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    LoginLDAP ldap = new LoginLDAP();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginManager</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginManager at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        // doPost(request, response);
        String ok = request.getParameter("ok");
        String tipo = request.getParameter("tipo");
        if (ok.equals("logout")) {
            request.getSession().removeAttribute("aluno");
            request.getSession().removeAttribute("professor");
            request.getSession().removeAttribute("usuario");
            request.getSession().removeAttribute("administrador");
        }
        if ("admin".equals(tipo)) {
            response.sendRedirect("admin/index.jsp");
            return;

        }
        response.sendRedirect("Login.jsp");
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        String ok = request.getParameter("ok");
        HttpSession session = request.getSession();
        if (ok.equals("login")) {

            String login = request.getParameter("username").trim();
            String senha = request.getParameter("password").trim();

            Usuario usuarioLocal = ehOAdmin(login, senha);
            Usuario usuarioLDAP = autenticarUsuario(login, senha);
            if (usuarioLocal != null) {
                request.getSession().setAttribute("UsuarioLogado", usuarioLocal);
                System.out.println("Logado como Administrador do sistema");
                response.sendRedirect("index.jsp");
            } else {
                if (!login.equals("admin") && !verificarSegundoDigito(login.charAt(1))) {
                    if (usuarioLDAP != null) {
                        usuarioLocal = verificarNaBaseLocal(login, senha);
                        if (usuarioLocal != null) {
                            session.setAttribute("UsuarioLogado", usuarioLocal);
                            System.out.println("Logado através da base do Sistema");
                            response.sendRedirect("index.jsp");
                        } else {
                            Professor professor = setProfessorNaBaseLocal(usuarioLDAP);
                            session.setAttribute("Professor", professor);
                            session.setAttribute("UsuarioLogado", usuarioLDAP);
                            System.out.println("Logado através do LDAP");
                            response.sendRedirect("CadastrarProfessor.jsp");
                        }
                    } else {
                        /* Apenas para teste de usuário fora da UTFPR */
//                        usuarioLocal = verificarNaBaseLocal(login, senha);
//                        if (usuarioLocal != null) {
//                            session.setAttribute("UsuarioLogado", usuarioLocal);
//                            System.out.println("Logado através da base do Sistema");
//                            response.sendRedirect("index.jsp");
//                        }
                        /* Dentro das dependencias da UTFPR */
                        request.getSession().setAttribute("erroLogin", "Login ou Senha incorretos");
                        System.out.println("Não autenticou no LDAP");
                        response.sendRedirect("Login.jsp");
                    }
                } else {
                    request.getSession().setAttribute("erroLogin", "Login ou Senha incorretos");
                    System.out.println("Usuário não cadastrado no banco");
                    response.sendRedirect("Login.jsp");
                }
            }
        } else {
            session.removeAttribute("usuario");
            response.sendRedirect("Login.jsp");
        }

    }

    private Usuario autenticarUsuario(String login, String senha) {

        Usuario user = LDAP.buscarUsuario(login);
        System.out.println("****************" + login);

        if (user != null) {
            try {
                if (LDAP.autenticacao(login, senha)) {
                    return user;
                } else {
                    return null;
                }
            } catch (IncorrectCredentialsException e) {
                return null;
            }
        } else {
            return null;
        }

    }

    private Usuario ehOAdmin(String login, String senha) {
        if (login.equals("admin")) {
            Administrador admin = new AdministradorDao().obterPorLogin(login);
            Usuario usuario = new Usuario();
            usuario.setLogin(admin.getLogin());
            usuario.setEmail(admin.getEmail());
            usuario.setNome(admin.getNome());
            if (senha.equals("admin123")) {
                return usuario;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private Usuario verificarNaBaseLocal(String login, String senha) {
        if (login.isEmpty() || login.equals("")) {
            return null;
        } else {
            Professor professor = new ProfessorDao().obterPorLogin(login);
            Usuario usuario = new Usuario();
            usuario.setLogin(professor.getLogin());
            usuario.setEmail(professor.getEmail());
            usuario.setNome(professor.getNome());
            System.out.println(usuario.toString());
            return usuario;
        }
    }

    private Professor setProfessorNaBaseLocal(Usuario usuario) {
        if (usuario != null) {
            Professor professor = new Professor();
            professor.setEmail(usuario.getEmail());
            professor.setLogin(usuario.getLogin());
            professor.setNome(usuario.getNome());
            System.out.println(professor.toString());
            return professor;
        } else {
            return null;
        }
    }

    private boolean verificarSegundoDigito(char digito2) {
        switch (digito2) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                return false;
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
