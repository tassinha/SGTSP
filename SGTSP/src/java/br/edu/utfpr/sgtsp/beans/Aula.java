/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.sgtsp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ge
 */
@Entity
public class Aula implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Professor professor;
    @ManyToOne
    private Turma turma;
    @ManyToOne
    private Disciplina diciplina;
    //@Column(columnDefinition = "BLOB")
    //@Enumerated(EnumType.STRING)
    //private List<DescricaoHorarios> horarios;

    public Long getId() {
        return id;
    }

//    public Aula() {
//        this.horarios = new ArrayList<DescricaoHorarios>();
//    }
//
//    public void addHorario(DescricaoHorarios descricaoHorarios) {
//        this.horarios.add(descricaoHorarios);
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Disciplina getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(Disciplina diciplina) {
        this.diciplina = diciplina;
    }
}
