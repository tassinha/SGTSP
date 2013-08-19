package br.edu.utfpr.cm.sgtsp.hibernate;

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
        
      //addClass(Categoria.class);
      


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
