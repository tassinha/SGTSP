/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Professor;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;

/**
 *
 * @author joao
 */
public class ProfessorDao extends DaoGenerico<Professor> {

    public ProfessorDao() {
        super();
    }

    public ProfessorDao(Professor professor) {
        super(professor);
    }

    public Professor obterPorLogin(String login) {
        Criteria criteria = getCriteria();
        criteria.add(Expression.eq("login", login));
        return uniqueResult(criteria);
    }
//    public Professor obterPorLogin(String login) {
//        Professor professor = null;
//        if (login != null) {
//            Query select = this.getSessao().createQuery("FROM " + Professor.class.getSimpleName() + " WHERE login = '" + login + "'");
//            professor = (Professor) select.uniqueResult();
//        }
//        return professor;
//    }
}
