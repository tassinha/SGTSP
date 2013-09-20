/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Solicitacao;

/**
 *
 * @author josimar
 */
public class SolicitacaoDao extends DaoGenerico<Solicitacao> {

    public SolicitacaoDao() {
        super();
    }

    public SolicitacaoDao(Solicitacao solicitacao) {
        super(solicitacao);
    }
    
    
    
}
