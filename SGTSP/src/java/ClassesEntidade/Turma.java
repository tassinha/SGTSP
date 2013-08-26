/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesEntidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ge
 */
@Entity
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String codigo;
    
    @Column
    private String descricao;
    
    @ManyToOne
    private Coordenacao coordenacao;
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Coordenacao getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(Coordenacao coordenacao) {
        this.coordenacao = coordenacao;
    }

    
    
}
