package Entidades;

import Entidades.Disciplina;
import Entidades.Professor;
import Entidades.Turma;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-09-30T10:43:19")
@StaticMetamodel(Aula.class)
public class Aula_ { 

    public static volatile SingularAttribute<Aula, Long> id;
    public static volatile SingularAttribute<Aula, Turma> turma;
    public static volatile SingularAttribute<Aula, Disciplina> diciplina;
    public static volatile SingularAttribute<Aula, String> hora;
    public static volatile SingularAttribute<Aula, Professor> professor;

}