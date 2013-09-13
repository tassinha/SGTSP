package br.edu.utfpr.sgtsp.daos;

import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.sgtsp.hibernate.DaoGenerico;
import br.edu.utfpr.sgtsp.beans.Professor;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;

public class UsuarioDao extends DaoGenerico<Usuario> {
    public UsuarioDao(){
        super();
    }

    public UsuarioDao(Usuario usuario) {
        super(usuario);
    }    
    
    public Usuario obterPorLogin(String login) {
        Criteria criteria = getCriteria();
        criteria.add(Expression.eq("login", login));
        return uniqueResult(criteria);
    }
    
//    public Usuario obterPorLogin(String login) {
//        Usuario usuario = null;
//        if (login != null) {
//            System.out.println(Usuario.class.getSimpleName());
//            Query select = this.getSessao().createQuery("FROM " + Usuario.class.getSimpleName() + " WHERE login = '" + login + "'");
//            usuario = (Usuario) select.uniqueResult();
//        }
//        return usuario;
//    }
}

