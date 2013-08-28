/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesEntidade;

import java.io.Serializable;
import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKey;

/**
 *
 * @author Ge
 */
@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue
    private Long ID;
   
   

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    
    
}
