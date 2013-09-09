/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Turma;
import org.hibernate.Criteria;

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
    
    public boolean exist(String descricao){
        return getCampoTabelaIgualParametro("descricao", descricao).isEmpty();
    }
    
}
