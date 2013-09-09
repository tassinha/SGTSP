package br.edu.utfpr.cm.sgtsp.login;

import br.edu.utfpr.cm.saa.entidades.Papel;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.sgtsp.ldap.LDAP;
import br.edu.utfpr.cm.sgtsp.ldap.TransactionManager;
import br.edu.utfpr.sgtsp.beans.Professor;
import br.edu.utfpr.sgtsp.daos.PapelDao;
import br.edu.utfpr.sgtsp.daos.ProfessorDao;
import br.edu.utfpr.sgtsp.daos.UsuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authc.IncorrectCredentialsException;

@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String uLogin = request.getParameter("username");
        String uSenha = request.getParameter("password");


        try {

            //Usar em casa//
            Usuario usuarioLocal = ehOAdmin(uLogin, uSenha);
            //Usuario usuarioLocal = verificarNaBaseLocal(uLogin, uSenha);

            if (usuarioLocal != null) {
                request.getSession().setAttribute("UsuarioLogado", usuarioLocal);
                System.out.println("Passando aqui ************************");
                response.sendRedirect("index.jsp");

            } else {
                //Usar em casa//
                Usuario userInterno;
                if (!uLogin.equals("admin")) {
                    if (verificarNaBaseLocal(uLogin, uSenha) != null) {
                        usuarioLocal = verificarNaBaseLocal(uLogin, uSenha);
                        userInterno = garantirQueUsuarioEstaNaBaseDoGerenciador(usuarioLocal, out, request);
                        if (userInterno != null) {
                            if (userInterno.getPapelList().equals(new PapelDao().get(2))) {
                                request.getSession().setAttribute("UsuarioLogado", userInterno);
                                response.sendRedirect("index.jsp");
                            } else {
                                request.getSession().setAttribute("erroLogin", "Login ou Senha incorretos");
                                System.out.println("Else passando aqui -------------------------");
                                response.sendRedirect("Login.jsp");
                            }
                        }
                    } else {
                        usuarioLocal = autenticarUsuario(uLogin, uSenha);
                        if (usuarioLocal != null) {
                            userInterno = garantirQueUsuarioEstaNaBaseDoGerenciador(usuarioLocal, out, request);
                            if (userInterno != null) {
                                if (userInterno.getPapelList().equals(new PapelDao().get(2))) {
                                    request.getSession().setAttribute("UsuarioLogado", usuarioLocal);
                                    System.out.println("Pronto para cadastrar professor ----------------------");
                                    response.sendRedirect("CadastrarProfessor.jsp");
                                } else {
                                    request.getSession().setAttribute("erroLogin", "Login ou Senha incorretos");
                                    System.out.println("Else passando aqui -------------------------");
                                    response.sendRedirect("Login.jsp");
                                }
                            }
                        } else {
                            request.getSession().setAttribute("erroLogin", "Login ou Senha incorretos");
                            System.out.println("Passando aqui ++++++++++++++++++++++++++");
                            response.sendRedirect("Login.jsp");
                        }
                    }
                } else {
                    request.getSession().setAttribute("erroLogin", "Login ou Senha incorretos");
                    System.out.println("Passando aqui #################################");
                    response.sendRedirect("Login.jsp");
                }
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    private Usuario autenticarUsuario(String uLogin, String uSenha) {

        Usuario user = LDAP.buscarUsuario(uLogin);
        System.out.println("****************" + uLogin);

        if (user != null) {
            try {
                if (LDAP.autenticacao(uLogin, uSenha)) {
                    System.out.println("**************** Passei no if autenticar " + uLogin);
                    return user;
                } else {
                    System.out.println("**************** Passei no else do autenticar " + uLogin);
                    return null;
                }
            } catch (IncorrectCredentialsException e) {
                return null;
            }
        } else {
            System.out.println("**************** dei null" + uLogin);
            return null;
        }

    }

    private Usuario garantirQueUsuarioEstaNaBaseDoGerenciador(Usuario user, PrintWriter out, HttpServletRequest request) {

        request.getSession().removeAttribute("UsuarioLogado");

        if (!verificarSegundoDigito(user.getLogin().charAt(1))) {

            System.out.println("Entrei aqui!********* DaoProfessor");
            ProfessorDao pDao = new ProfessorDao();
            Professor professor = pDao.obterPorLogin(user.getLogin());

            if (professor != null) {
                if (professor.getPapel() == null) {
                    professor.setPapel(new PapelDao().get(2));
                    pDao.persist();
                    request.getSession().setAttribute("UsuarioLogado", professor);
                    return user;
                } else {
                    request.getSession().setAttribute("UsuarioLogado", professor);
                    return user;
                }
            } else {
                TransactionManager.beginTransaction();
                professor = new Professor();
                professor.setNome(user.getNome());
                professor.setLogin(user.getLogin());
                professor.setEmail(user.getEmail());
                professor.setPapel(new PapelDao().get(2));
                pDao.persist();
                TransactionManager.commit();
                request.getSession().setAttribute("UsuarioLogado", professor);
                return user;
            }
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

    private Usuario verificarNaBaseLocal(String uLogin, String uSenha) {
        if (uLogin.isEmpty() || uLogin.equals("")) {
            return null;
        } else {
            TransactionManager.beginTransaction();
            UsuarioDao dao = new UsuarioDao();
            Usuario usuario = dao.obterPorLogin(uLogin);
            System.out.println("AQUI *************************************");
            System.out.println(usuario);
            return usuario;
        }
    }

    private Usuario ehOAdmin(String uLogin, String uSenha) {
        if (uLogin.equals("admin")) {
            System.out.println("++++++++++++++" + uLogin);
            UsuarioDao dao = new UsuarioDao();
            System.out.println(" Passandooooooooo*********************************");
            Usuario usuario = dao.obterPorLogin(uLogin);
            System.out.println("");
            System.out.println("Senha " + uSenha);
            if (uSenha.equals("admin123")) {
                return usuario;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    private String qualOPapel(Usuario user) {
        System.out.println(user.toString());
        if (user.getPapelList().get(0).equals(new PapelDao().get(1))) {
            return "Coordenador";
        } else if (user.getPapelList().get(0).equals(new PapelDao().get(2))) {
            return "Professor";
        } else if (user.getPapelList().get(0).equals(new PapelDao().get(3))) {
            return "Administrador";
        } else {
            return null;
        }
    }
}
