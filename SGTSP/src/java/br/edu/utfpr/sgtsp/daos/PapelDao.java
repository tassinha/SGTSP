package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.saa.entidades.Papel;
import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;

public class PapelDao extends DaoGenerico<Papel> {
    public PapelDao(){
        super();
    }

    public PapelDao(Papel papel) {
        super(papel);
    }    
}