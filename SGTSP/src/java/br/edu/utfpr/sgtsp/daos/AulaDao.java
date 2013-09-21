/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Aula;
import br.edu.utfpr.sgtsp.beans.Professor;
import java.util.List;

/**
 *
 * @author josimar
 */
public class AulaDao extends DaoGenerico<Aula>{

    public AulaDao() {
        super();
    }

    public AulaDao(Aula aula) {
        super(aula);
    }
    public List<Aula> getAulasPorProfessor(Professor professor ){
        
        return getCampoTabelaIgualParametro("professor", professor);
    }
    
    
}
