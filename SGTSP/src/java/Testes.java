
import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.sgtsp.hibernate.Mapeador;
import br.edu.utfpr.sgtsp.beans.Aula;
import br.edu.utfpr.sgtsp.beans.DescricaoHorarios;
import br.edu.utfpr.sgtsp.beans.Horario;
import br.edu.utfpr.sgtsp.beans.Professor;
import br.edu.utfpr.sgtsp.daos.AulaDao;
import br.edu.utfpr.sgtsp.daos.HorarioDao;
import br.edu.utfpr.sgtsp.daos.ProfessorDao;
import br.edu.utfpr.sgtsp.daos.UsuarioDao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josimar
 */
public class Testes {
    public static void main(String[] args) {
        Mapeador.criarTabelas();
        Horario h = new Horario();
        Aula aula = new Aula();
        new AulaDao(aula).persist();
        h.addAula(DescricaoHorarios.SEG_M_1,aula);
        new HorarioDao(h).persist();
        
        Usuario user = new Usuario();
        user.setLogin("admin");
        user.setNome("Administrador");
        user.setEmail("admin@admin.com");
        user.setSenha("admin123");
        
        new UsuarioDao(user).persist();
        Professor p = new Professor();
        p.setLogin("Kassia");
        new ProfessorDao(p).persist();
        Professor pr = new ProfessorDao().obterPorLogin("Kassia");
        System.out.println(pr.getLogin());
        
    }
}
