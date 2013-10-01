/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author Ge
 */
public class DAO {

    private EntityManager em;

    public DAO(EntityManager createEntityManager) {
        this.em = createEntityManager;
    }

    public DAO() {
        super();
    }

    /**
     * Este método insere um objeto utilizando o EntityManager. Essa
     * transação é atômica.
     *
     * @param obj Objeto da Entidade do seu sistema.
     */
    public void insere(Object obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public void atualiza(Object obj) {
        try {
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public void remove(Object obj) {
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public List seleciona(String sql) {
        return (em.createQuery(sql).getResultList());
    }

    public Object selecionaEspecifico(String sql) {
        return (em.createQuery(sql).getSingleResult());
    }
    
    public boolean existe(Object obj) {
        return (em.contains(obj));
    }

    public List consultarTudo(String entidade) {
        return em.createQuery("select c from " + entidade + " c").getResultList();
    }

    public Object consultarPeloId(Class c, int id) {
        return em.find(c, id);
    }

    public List consultarNativo(String sql) {
        return em.createNativeQuery(sql).getResultList();
    }

    public Object consultarObjectNativo(String sql) {
        return em.createNativeQuery(sql).getSingleResult();
    }

    public boolean executarNativo(String sql) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sgtsp", "root", "root");

            return con.createStatement().execute(sql);

        } catch (Exception ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
