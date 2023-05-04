
package cl.duoc.AerolineaLaser.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;


/**
 *
 * @author Angy
 */

@Data //para que me consiga los Getter y Setter
@Entity //Porque ahora nuestra clase Usuario es una entidad de BDD. Es normal que aparezca el bombillo amarillo. 
@Table(name="usuario") //para que no tenga errores en reconocer la tabla en la BDD
public class Usuario implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idUsuario; //idPersona es la identidad de la tabla/entidad de persona en mi BDD
    private String nombre;
    private String apellido;
    private String email;
    private String usuarionom;

}


