/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.sgtsp.Servlets;

import br.edu.utfpr.cm.sgtsp.parsehtml.ParseHtmlHorario;
import br.edu.utfpr.sgtsp.beans.Coordenacao;
import br.edu.utfpr.sgtsp.beans.Disciplina;
import br.edu.utfpr.sgtsp.beans.Turma;
import br.edu.utfpr.sgtsp.daos.AulaDao;
import br.edu.utfpr.sgtsp.daos.CoordenacaoDao;
import br.edu.utfpr.sgtsp.daos.DisciplinaDao;
import br.edu.utfpr.sgtsp.daos.TurmaDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.DiskFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.jsoup.nodes.Document;

/**
 *
 * @author josimar
 */
public class ProcessaHorario extends HttpServlet {

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
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcessaHorario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessaHorario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    protected void print(HttpServletRequest request, HttpServletResponse response, String s)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /* TODO output your page here. You may use following sample code. */

        out.println("<h3>Servlet ProcessaHorario at " + s + "</h3>");

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
        //processRequest(request, response);

        Disciplina d;
        Turma t;

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        /* TODO output your page here. You may use following sample code. */
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet ProcessaHorario</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Conteudo do MAP </h1>");


//        String pasta = getServletContext().getContextPath();
        String pasta = "/home/joao/Downloads/";
        File f = new File(pasta);
        if (f.isDirectory()) {
        } else {
            f.mkdir();
        }
        String caminhoTemp = pasta + "/temp";
        File pastaTemp = new File(caminhoTemp);
        if (pastaTemp.isDirectory()) {
        } else {
            pastaTemp.mkdir();
        }

        File arquivo = null;


        if (FileUpload.isMultipartContent(request)) {
            DiskFileUpload upload = new DiskFileUpload();
            upload.setRepositoryPath(caminhoTemp);

            try {
                List items = null;
                items = upload.parseRequest(request);
                Iterator iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem item = (FileItem) iter.next();

                    if (!item.isFormField()) {
                        String nome = item.getName().toString();
                        String nomeArquivo = nome.substring(nome.lastIndexOf("\\") + 1);
                        arquivo = new File(pasta + nomeArquivo);
                        if (arquivo.exists()) {
                            arquivo = new File(pasta + "duplicado" + Calendar.getInstance().getTimeInMillis() + nomeArquivo);
                            item.write(arquivo);
                        } else {
                            item.write(arquivo);
                        }


                        Map m = new ParseHtmlHorario().Parse(arquivo);
                        Set<String> keySet = m.keySet();
                        print(request, response, "teste " + keySet.size());
                        for (String key : keySet) {
                            String s = (String) m.get(key);
                            out.println("<p>" + s + "</p>");

                            //------ teste JP -----\\

                            if (s.length() > 3) {

                                s.trim();
                                String[] vetor = s.split("-");
                                if (vetor.length == 2) {
                                    for (String string : vetor) {
                                        System.out.println(string);
                                    }
                                    String disciplina = vetor[0];
                                    String turma = vetor[1];

                                    d = new Disciplina();
                                    t = new Turma();

                                    int indice = disciplina.lastIndexOf(" ");
                                    int indice2 = turma.lastIndexOf(" ");
                                    String descricao = disciplina.substring(0, indice);
                                    String codigo = disciplina.substring(indice, disciplina.length());
                                    String sala = turma.substring(0 ,indice2);
                                    String codigoTurma = turma.substring(indice2, turma.length());
                                    System.out.println("@@@@@@@@@@@@@" + turma);

                                    d.setNome(descricao);
                                    d.setCodigo(codigo);
                                    d.setCoordenacao(new CoordenacaoDao().get(new Long("1")));
                                    
                                    t.setCodigo(codigoTurma);
                                    t.setCoordenacao(new CoordenacaoDao().get(new Long("1")));
                                    t.setDescricao(codigoTurma);

                                    if (new DisciplinaDao().exist(d.getCodigo())) {
                                        new DisciplinaDao(d).persist();
                                        out.println("<p>  Ok passouuuuuuuuuuuu </p>");
                                    }
                                    
                                    
                                    if (new TurmaDao().exist(t.getCodigo())) {
                                        new TurmaDao(t).persist();
                                        out.println("<p>  Ok passouuuuuuuuuuuu </p>");
                                    }

                                }


                                //------ fim do teste JP ----\\



//                            if (s.length() > 3) {
//                                out.println("<p>Chave - > " + key + " valor: " + s + "</p>");
//                            }

                            }
                        }
                        out.println("</body>");
                        out.println("</html>");

                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (FileUploadException e) {
                System.out.println(e);
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
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
