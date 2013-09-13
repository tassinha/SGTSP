package br.edu.utfpr.cm.sgtsp.hibernate;

import br.edu.utfpr.cm.saa.entidades.Papel;
import br.edu.utfpr.cm.saa.entidades.Sistema;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.sgtsp.beans.Administrador;
import br.edu.utfpr.sgtsp.beans.Aula;
import br.edu.utfpr.sgtsp.beans.Coordenacao;
import br.edu.utfpr.sgtsp.beans.Disciplina;
import br.edu.utfpr.sgtsp.beans.Horario;
import br.edu.utfpr.sgtsp.beans.Professor;
import br.edu.utfpr.sgtsp.beans.Turma;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Mapeador {

    private static AnnotationConfiguration annotationConfiguration = new AnnotationConfiguration();
    private static SessionFactory factory;

    static {
        mapear();
       Mapeador.annotationConfiguration.setProperty("hibernate.current_session_context_class","thread");
    }

    public static void criarTabelas() {
        new SchemaExport(annotationConfiguration).create(true, true);
    }

    public static void addClass(Class classe) {
        annotationConfiguration.addAnnotatedClass(classe);
    }

    public static void excluirTabelas() {
        new SchemaExport(annotationConfiguration).drop(true, true);
    }

    public static void mapear() {
        
      addClass(Aula.class);
      addClass(Disciplina.class);
      addClass(Horario.class);
      addClass(Professor.class);
      addClass(Turma.class);
      addClass(Administrador.class);
      addClass(Coordenacao.class);
     // addClass(Sistema.class);
     // addClass(Usuario.class);
      


    }

    public static Session getSessao() {
        factory = annotationConfiguration.buildSessionFactory();
        Session sessao = factory.openSession();
        factory.close();
        return sessao;
    }
    public static SessionFactory getSessionFactory(){
        return annotationConfiguration.buildSessionFactory();
    }
}
