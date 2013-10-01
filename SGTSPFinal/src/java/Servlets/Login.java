/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Administrador;
import Entidades.Aula;
import Entidades.Coordenacao;
import Entidades.Professor;
import LDAP.LDAP;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.shiro.authc.IncorrectCredentialsException;

/**
 *
 * @author Ge
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager conecta = Persistence.createEntityManagerFactory("SGTSPFinalPU").createEntityManager();
        // processRequest(request, response);
        String ok = request.getParameter("ok");
        HttpSession session = request.getSession();
        if (ok.equals("login")) {

            String login = request.getParameter("username").trim();
            String senha = request.getParameter("password").trim();
            if ("".equals(senha)) {
                request.getSession().setAttribute("erroLogin", "Erro: Senha não informada");
                response.sendRedirect("index.jsp");
                return;
            }

            Usuario usuarioLocal = ehOAdmin(login, senha);
            Usuario usuarioLDAP = autenticarUsuario(login, senha);
            if (usuarioLocal != null) {
                Professor professor = (Professor) new Dao.DAO(conecta).selecionaEspecifico("SELECT p FROM Professor p WHERE p.login='" + login + "'");
                request.getSession().setAttribute("ProfessorLogado", professor);
                //request.getSession().setAttribute("UsuarioLogado", usuarioLocal);
                System.out.println("Logado como Administrador do sistema");
                List<Aula> aulas = new Dao.DAO(conecta).seleciona("SELECT a FROM Aula a WHERE a.professor.id=" + professor.getId() + " ORDER BY a.hora ASC");
                request.getSession().setAttribute("aulas", aulas);
                response.sendRedirect("site/upload.jsp");
                //response.sendRedirect("index.jsp");
            } else {
                if (!login.equals("admin")) {
                    /* if (usuarioLDAP != null && !verificarSegundoDigito(login.charAt(1)))
                     adicionar esta linha ao final do projeto para apenas professores logarem */
                    if (usuarioLDAP != null) {
                        usuarioLocal = verificarNaBaseLocal(login, senha);
                        if (usuarioLocal != null) {
                            Professor professor = (Professor) new Dao.DAO(conecta).selecionaEspecifico("SELECT p FROM Professor p WHERE p.login='" + login + "'");
                            session.setAttribute("ProfessorLogado", professor);
                            if (verificarHorarioCadastrado(professor, request)) {
                                response.sendRedirect("site/upload.jsp");
                            } else {
                                //session.setAttribute("UsuarioLogado", usuarioLocal);
                                //System.out.println("Logado através da base do Sistema");
                                response.sendRedirect("site/principal.jsp");
                            }
                        } else {
                            Professor professor = setProfessorNaBaseLocal(usuarioLDAP);
                            session.setAttribute("ProfessorLogado", professor);
                            session.setAttribute("UsuarioLogado", usuarioLDAP);
                            System.out.println("Logado através do LDAP");
                            response.sendRedirect("site/upload.jsp");
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
                        response.sendRedirect("index.jsp");
                    }
                } else {
                    request.getSession().setAttribute("erroLogin", "Login ou Senha incorretos");
                    System.out.println("Usuário não cadastrado no banco");
                    response.sendRedirect("index.jsp");
                }
            }
        } else {
            session.removeAttribute("usuario");
            response.sendRedirect("index.jsp");
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

    private boolean verificarHorarioCadastrado(Professor professor, HttpServletRequest request) {
        EntityManager conecta = Persistence.createEntityManagerFactory("SGTSPFinalPU").createEntityManager();
        boolean valor = false;
        List<Aula> aulas = new Dao.DAO(conecta).seleciona("SELECT a FROM Aula a WHERE a.professor.id=" + professor.getId());
        if (aulas.isEmpty()) {
            valor = true;
        }
        request.getSession().setAttribute("aulas", aulas);
        return valor;
    }

    private Usuario ehOAdmin(String login, String senha) {
        EntityManager conecta = Persistence.createEntityManagerFactory("SGTSPFinalPU").createEntityManager();
        if (login.equals("admin")) {
            Administrador admin = (Administrador) new Dao.DAO(conecta).selecionaEspecifico("SELECT a FROM Administrador a WHERE a.login='" + login + "'");
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
        EntityManager conecta = Persistence.createEntityManagerFactory("SGTSPFinalPU").createEntityManager();
        if (login.isEmpty() || login.equals("")) {
            return null;
        } else {
            List<Professor> professor = new Dao.DAO(conecta).seleciona("SELECT p FROM Professor p WHERE p.login='" + login + "'");
            if (!professor.isEmpty()) {
                Usuario usuario = new Usuario();
                usuario.setLogin(professor.get(0).getLogin());
                usuario.setEmail(professor.get(0).getEmail());
                usuario.setNome(professor.get(0).getNome());
                System.out.println(usuario.toString());
                return usuario;
            } else {
                return null;
            }
        }
    }

    private Professor setProfessorNaBaseLocal(Usuario usuario) {
        EntityManager conecta = Persistence.createEntityManagerFactory("SGTSPFinalPU").createEntityManager();
        if (usuario != null) {
            Professor professor = new Professor();
            professor.setCoordenacao((Coordenacao) new Dao.DAO(conecta).selecionaEspecifico("SELECT c FROM Coordenacao c WHERE c.id="+1));
            professor.setEmail(usuario.getEmail());
            professor.setLogin(usuario.getLogin());
            professor.setNome(usuario.getNome());
            new Dao.DAO(conecta).insere(professor);
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
}
