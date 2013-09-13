/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Coordenacao;

/**
 *
 * @author josimar
 */
public class CoordenacaoDao extends DaoGenerico<Coordenacao> {

    public CoordenacaoDao() {
        super();
    }

    public CoordenacaoDao(Coordenacao coordenacao) {
        super(coordenacao);
    }
    
}
