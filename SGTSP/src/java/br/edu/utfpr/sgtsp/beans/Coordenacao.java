/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Ge
 */
@Entity
public class Coordenacao implements Serializable {
    @OneToMany(mappedBy = "coordenacao")
    private List<Professor> professors;
    @OneToMany(mappedBy = "coordenacao")
    private List<Turma> turmas;
    @OneToMany(mappedBy = "coordenacao")
    private List<Disciplina> diciplinas;

    private static final long serialVersionUID = 1L;
    @Id
    private String codigo;
    @Column
    private String descricao;

    
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

    public List<Disciplina> getDiciplinas() {
        return diciplinas;
    }

    public void setDiciplinas(List<Disciplina> diciplinas) {
        this.diciplinas = diciplinas;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
