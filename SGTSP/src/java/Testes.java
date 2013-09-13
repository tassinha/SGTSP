
import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.sgtsp.hibernate.Mapeador;
import br.edu.utfpr.sgtsp.beans.Administrador;
import br.edu.utfpr.sgtsp.beans.Aula;
import br.edu.utfpr.sgtsp.beans.Coordenacao;
import br.edu.utfpr.sgtsp.beans.DescricaoHorarios;
import br.edu.utfpr.sgtsp.beans.Disciplina;
import br.edu.utfpr.sgtsp.beans.Horario;
import br.edu.utfpr.sgtsp.beans.Professor;
import br.edu.utfpr.sgtsp.beans.Turma;
import br.edu.utfpr.sgtsp.daos.AdministradorDao;
import br.edu.utfpr.sgtsp.daos.AulaDao;
import br.edu.utfpr.sgtsp.daos.CoordenacaoDao;
import br.edu.utfpr.sgtsp.daos.DisciplinaDao;
import br.edu.utfpr.sgtsp.daos.HorarioDao;
import br.edu.utfpr.sgtsp.daos.ProfessorDao;
import br.edu.utfpr.sgtsp.daos.TurmaDao;
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
        
        Administrador administrador = new Administrador();
        administrador.setLogin("admin");
        administrador.setNome("Administrador");
        administrador.setEmail("admin@admin.com");
        administrador.setSenha("admin123");
        new AdministradorDao(administrador).persist();
        Professor p = new Professor();
        p.setLogin("Kassia");
        
        new ProfessorDao(p).persist();
        Professor pr = new ProfessorDao().obterPorLogin("Kassia");
        System.out.println(pr.getLogin());
        Coordenacao c = new Coordenacao();
        c.setCodigo("COINT");
        new CoordenacaoDao(c).persist();
        Turma t = new Turma("NE5A", "AAAAAAAAAA", c);
        new TurmaDao(t).persist();
        Disciplina d = new Disciplina("PI35A", "Projeto Integrador II", c);
        
        new DisciplinaDao(d).persist();
        Aula a = new Aula();
        a.setDiciplina(d);
        a.setProfessor(pr);
        a.setTurma(t);
       new AulaDao(a).persist();
        
        Horario h = new Horario();
      
        h.addAula(DescricaoHorarios.SEG_M_1,a);
        new HorarioDao(h).persist();
        
    }
}
