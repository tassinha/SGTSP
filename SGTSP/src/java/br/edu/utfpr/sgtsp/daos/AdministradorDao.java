/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Administrador;

/**
 *
 * @author josimar
 */
public class AdministradorDao extends DaoGenerico<Administrador> {

    public AdministradorDao() {
        super();
    }

    public AdministradorDao(Administrador  administrador) {
        super( administrador);
    }
    
}
