package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import org.hibernate.Query;

public class UsuarioDao extends DaoGenerico<Usuario> {
    public UsuarioDao(){
        super();
    }

    public UsuarioDao(Usuario usuario) {
        super(usuario);
    }    
    
    public Usuario obterPorLogin(String login) {
        Usuario usuario = null;
        if (login != null) {
            Query select = this.getSessao().createQuery("FROM " + Usuario.class.getSimpleName() + " WHERE login = '" + login + "'");
            usuario = (Usuario) select.uniqueResult();
        }
        return usuario;
    }
}

