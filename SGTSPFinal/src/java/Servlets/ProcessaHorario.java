/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Aula;
import Entidades.Coordenacao;
import Entidades.Disciplina;
import Entidades.Professor;
import Entidades.Turma;
import ParseHtml.ParseHtmlHorario;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.DiskFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

/**
 *
 * @author Ge
 */
@WebServlet(name = "ProcessaHorario", urlPatterns = {"/site/ProcessaHorario"})
public class ProcessaHorario extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        EntityManager conecta = Persistence.createEntityManagerFactory("SGTSPFinalPU").createEntityManager();

        Disciplina d;
        Turma t;
        Professor p;


        Professor professor = (Professor) request.getSession().getAttribute("ProfessorLogado");
        response.setContentType("text/html;charset=UTF-8");



        /* TODO output your page here. You may use following sample code. */


//        String pasta = getServletContext().getContextPath();
        String pasta = "C:\\Users\\Ge\\Downloads";
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
                        String valor = "";
                        int contador = 1;
                        String aux1 = "";
                        List<Aula> aulas = new ArrayList<Aula>();
                        for (String key : keySet) {
                            String s = (String) m.get(key);

                            //------ teste JP -----\\

                            if (s.length() > 3) {

                                s.trim();
                                String[] vetor = s.split("-");
                                if (vetor.length == 2) {

                                    String disciplina = vetor[0];
                                    String turma = vetor[1];

                                    d = new Disciplina();
                                    t = new Turma();

                                    int indice = disciplina.lastIndexOf(" ");
                                    int indice2 = turma.lastIndexOf(" ");
                                    String descricao = disciplina.substring(0, indice);
                                    String codigo = disciplina.substring(indice, disciplina.length());
                                    String sala = turma.substring(0, indice2);
                                    String codigoTurma = turma.substring(indice2, turma.length());
                                    codigo = codigo.replace(" ", "");
                                    codigoTurma = codigoTurma.replace(" ", "");

                                    if (valor.equals("")) {
                                        valor = codigo;
                                    }

                                    //System.out.println("@@@@@@@@@@@@@@@@@"+new Dao.DAO(conecta).seleciona("SELECT d FROM Disciplina d WHERE d.codigo='" + codigo + "'"));
                                    if (new Dao.DAO(conecta).seleciona("SELECT d FROM Disciplina d WHERE d.codigo='" + codigo + "'").isEmpty()) {
                                        d.setNome(descricao);
                                        d.setCodigo(codigo);
                                        d.setCoordenacao((Coordenacao) new Dao.DAO(conecta).selecionaEspecifico("SELECT c FROM Coordenacao c WHERE c.id=" + 1));
                                        new Dao.DAO(conecta).insere(d);

                                    } else {
                                        d = (Disciplina) new Dao.DAO(conecta).selecionaEspecifico("SELECT d FROM Disciplina d WHERE d.codigo='" + codigo + "'");
                                    }


                                    if (new Dao.DAO(conecta).seleciona("SELECT t FROM Turma t WHERE t.codigo='" + codigoTurma + "'").isEmpty()) {
                                        t.setCodigo(codigoTurma);
                                        t.setCoordenacao((Coordenacao) new Dao.DAO(conecta).selecionaEspecifico("SELECT c FROM Coordenacao c WHERE c.id=" + 1));
                                        t.setDescricao(codigoTurma);
                                        new Dao.DAO(conecta).insere(t);
                                    } else {
                                        t = (Turma) new Dao.DAO(conecta).selecionaEspecifico("SELECT t FROM Turma t WHERE t.codigo='" + codigoTurma + "'");
                                    }

                                    if (aux1.equals("")) {
                                        aux1 = key.substring(0, 2);
                                    }
                                    Aula aula = new Aula();
                                    aula.setHora(key);
                                    String aux = key.substring(0, 2);
                                    aula.setDiciplina(d);
                                    aula.setTurma(t);
                                    p = (Professor) new Dao.DAO(conecta).selecionaEspecifico("SELECT p FROM Professor p WHERE p.id= " + professor.getId());
                                    if (valor.equals(codigo) && aux1.equals(aux)) {
                                        aula.setIdentificador(contador);
                                    } else {
                                        valor = codigo;
                                        aula.setIdentificador(contador + 1);
                                        contador = contador + 1;
                                        aux1 = aux;
                                    }
                                    aula.setProfessor(p);
//
//
//                                    //if (new AulaDao().exist(aula.getDiciplina().getId())) {
                                    aulas.add(aula);
                                    //new Dao.DAO(conecta).insere(aula);
                                    // }

                                }


                                //------ fim do teste JP ----\\



//                            if (s.length() > 3) {
//                                out.println("<p>Chave - > " + key + " valor: " + s + "</p>");
//                            }

                            }
                        }
                        //List<Aula> aulas = new Dao.DAO(conecta).seleciona("SELECT a FROM Aula a WHERE a.professor.id=" + professor.getId() + " ORDER BY a.hora ASC");
                        List<Aula> aux = new ArrayList<Aula>();
                        String horario = "";
                        Aula aulaauxiliar = null;
                        for (int i = 0; i < aulas.size(); i++) {
                            if (i == aulas.size() - 1) {
                                aulaauxiliar = aulas.get(i);
                                horario = horario + aulas.get(i).getHora();
                                aulaauxiliar.setHora(horario);
                                aux.add(aulaauxiliar);
                                horario = "";
                                aulaauxiliar = null;
                            } else {
                                if (aulas.get(i).getIdentificador() == aulas.get(i + 1).getIdentificador()) {
                                    horario = horario + aulas.get(i).getHora()+" ";
                                } else {
                                    aulaauxiliar = aulas.get(i);
                                    horario = horario + aulas.get(i).getHora();
                                    aulaauxiliar.setHora(horario);
                                    aux.add(aulaauxiliar);
                                    horario = "";
                                    aulaauxiliar = null;
                                }
                            }
                        }
                        for (Aula aula : aux) {
                            new Dao.DAO(conecta).insere(aula);
                        }
                        List<Aula> aulas1 = new Dao.DAO(conecta).seleciona("SELECT a FROM Aula a WHERE a.professor.id=" + professor.getId() + " ORDER BY a.hora ASC");
                        request.getSession().setAttribute("aulas", aulas1);
                        response.sendRedirect("principal.jsp");

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
}
