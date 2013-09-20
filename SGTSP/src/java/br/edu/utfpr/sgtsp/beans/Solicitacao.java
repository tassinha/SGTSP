/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author josimar
 */
@Entity
public class Solicitacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Professor professorRequerente;
    @OneToMany
    private List<Aula> aulasSolicitadas;
    @OneToMany
    private List<Aula> aulasSubstituidoras;

    public Solicitacao() {
        this.aulasSolicitadas = new ArrayList<Aula>();
    }
    
    public void addAula(Aula aula){
        aulasSolicitadas.add(aula);
    }
    public Professor getProfessorRequerente() {
        return professorRequerente;
    }

    public void setProfessorRequerente(Professor professorRequerente) {
        this.professorRequerente = professorRequerente;
    }

    public List<Aula> getAulasSolicitadas() {
        return aulasSolicitadas;
    }

    public void setAulasSolicitadas(List<Aula> aulasSolicitadas) {
        this.aulasSolicitadas = aulasSolicitadas;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitacao)) {
            return false;
        }
        Solicitacao other = (Solicitacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.sgtsp.beans.Solicitacao[ id=" + id + " ]";
    }
    
}
