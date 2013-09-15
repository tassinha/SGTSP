/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Administrador;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

/**
 *
 * @author josimar
 */
public class AdministradorDao extends DaoGenerico<Administrador> {

    public AdministradorDao() {
        super();
    }

    public AdministradorDao(Administrador administrador) {
        super(administrador);
    }

    public Administrador obterPorLogin(String login) {
        Criteria criteria = getCriteria();
        criteria.add(Expression.eq("login", login));
        return uniqueResult(criteria);
    }
}
