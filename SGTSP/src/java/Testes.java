
import br.edu.utfpr.cm.sgtsp.hibernate.Mapeador;
import br.edu.utfpr.sgtsp.beans.Aula;
import br.edu.utfpr.sgtsp.beans.DescricaoHorarios;
import br.edu.utfpr.sgtsp.beans.Horario;
import br.edu.utfpr.sgtsp.daos.AulaDao;
import br.edu.utfpr.sgtsp.daos.HorarioDao;

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
        h.addAula(1,aula);
        new HorarioDao(h).persist();
    }
}
