/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.cm.sgtsp.nucleo;

import br.edu.utfpr.sgtsp.beans.Aula;
import br.edu.utfpr.sgtsp.beans.DescricaoHorarios;
import br.edu.utfpr.sgtsp.beans.Horario;
import br.edu.utfpr.sgtsp.daos.HorarioDao;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 *
 * @author josimar
 */
public class Nucleo {
    public void solicitarTroca(Aula aula){
        Horario h = new HorarioDao().get(1);
        HashMap<DescricaoHorarios, Aula> aulas = h.getAulas();
        Set<DescricaoHorarios> keySet = aulas.keySet();
      //  List<aula> 
                
        for(DescricaoHorarios key:keySet){
            Aula a = aulas.get(key);
        }
       
        
    }
    public void solicitarSubstituicao(Aula aula){
        
    }
}
