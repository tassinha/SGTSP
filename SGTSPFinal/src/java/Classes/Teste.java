/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Dao.DAO;
import Entidades.Administrador;
import Entidades.Aula;
import Entidades.Coordenacao;
import Entidades.Turma;
import javax.persistence.Persistence;

/**
 *
 * @author Ge
 */
public class Teste {
    public static void main(String[] args) {
        Coordenacao coordenacao = new Coordenacao();
        coordenacao.setCodigo("COINT");
        coordenacao.setDescricao("Coordenação de Informática");
       
        new Dao.DAO(Persistence.createEntityManagerFactory("SGTSPFinalPU").createEntityManager()).insere(coordenacao);
        
        
    }
}
