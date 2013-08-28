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
public class Diciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String codigo;
    
    @Column
    private String nome;
    
    @ManyToOne
    private Coordenacao coordenacao;
    
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Coordenacao getCoordenacao() {
        return coordenacao;
    }

    public void setCoordenacao(Coordenacao coordenacao) {
        this.coordenacao = coordenacao;
    }
    
    
    
}
