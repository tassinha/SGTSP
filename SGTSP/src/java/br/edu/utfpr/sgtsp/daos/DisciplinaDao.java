/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico; 
import br.edu.utfpr.sgtsp.beans.Disciplina;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

/**
 *
 * @author joao
 */
public class DisciplinaDao extends DaoGenerico<Disciplina> {

    public DisciplinaDao() {
        super();
    }
    

    public DisciplinaDao(Disciplina disciplina) {
        super(disciplina);
    }

    public boolean exist(String codigo){
        return !getCampoTabelaIgualParametro("codigo", codigo).isEmpty();
    }
    
    public Disciplina obtem(String codigo){
        Criteria criteria = getCriteria();
        criteria.add(Expression.eq("codigo", codigo));
        return uniqueResult(criteria);
    }
}
