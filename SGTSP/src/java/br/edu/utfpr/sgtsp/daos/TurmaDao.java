/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Disciplina;
import br.edu.utfpr.sgtsp.beans.Turma;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

/**
 *
 * @author joao
 */
public class TurmaDao extends DaoGenerico<Turma> {

    public TurmaDao() {
        super();
    }
    

    public TurmaDao(Turma turma) {
        super(turma);
    }
    
    public boolean exist(String codigo){
        return !getCampoTabelaIgualParametro("codigo", codigo).isEmpty();
    }
    
    public Turma obtem(String codigo){
        Criteria criteria = getCriteria();
        criteria.add(Expression.eq("codigo", codigo));
        return uniqueResult(criteria);
    }
    
}
