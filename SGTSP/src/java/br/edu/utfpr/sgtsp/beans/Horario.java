/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.beans;

import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author josimar
 */
@Entity
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   @Column(columnDefinition = "LONGBLOB")  
    private HashMap<DescricaoHorarios, Aula> aulas;

    public Long getId() {
        return id;
    }

    public void addAula(DescricaoHorarios descricaoHorarios, Aula aula) {
        aulas.put(descricaoHorarios, aula);
    }

    public Horario() {
        aulas = new HashMap<DescricaoHorarios, Aula>();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HashMap<DescricaoHorarios, Aula> getAulas() {
        return aulas;
    }

    public void setAulas(HashMap<DescricaoHorarios, Aula> aulas) {
        this.aulas = aulas;
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
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.utfpr.sgtsp.beans.Horario[ id=" + id + " ]";
    }
}