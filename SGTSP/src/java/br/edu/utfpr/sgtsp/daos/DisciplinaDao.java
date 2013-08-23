/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico; 
import br.edu.utfpr.sgtsp.beans.Disciplina;

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
    
}
