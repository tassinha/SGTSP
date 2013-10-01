package Entidades;

import Entidades.Coordenacao;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-09-30T10:43:19")
@StaticMetamodel(Professor.class)
public class Professor_ { 

    public static volatile SingularAttribute<Professor, Long> id;
    public static volatile SingularAttribute<Professor, byte[]> assinatura;
    public static volatile SingularAttribute<Professor, String> email;
    public static volatile SingularAttribute<Professor, Boolean> isCoordenador;
    public static volatile SingularAttribute<Professor, String> nome;
    public static volatile SingularAttribute<Professor, String> login;
    public static volatile SingularAttribute<Professor, Coordenacao> coordenacao;

}