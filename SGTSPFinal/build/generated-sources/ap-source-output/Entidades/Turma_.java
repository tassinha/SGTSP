package Entidades;

import Entidades.Coordenacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-09-30T10:43:19")
@StaticMetamodel(Turma.class)
public class Turma_ { 

    public static volatile SingularAttribute<Turma, Long> id;
    public static volatile SingularAttribute<Turma, String> codigo;
    public static volatile SingularAttribute<Turma, String> descricao;
    public static volatile SingularAttribute<Turma, Coordenacao> coordenacao;

}