/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Professor;

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
}
