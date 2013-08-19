/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Horario;

/**
 *
 * @author joao
 */
public class HorarioDao extends DaoGenerico<Horario> {

    public HorarioDao() {
        super();
    }

    public HorarioDao(Horario horario) {
        super(horario);
    }
}
