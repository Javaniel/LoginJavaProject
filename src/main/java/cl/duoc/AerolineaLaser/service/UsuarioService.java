
package cl.duoc.AerolineaLaser.service;

import java.util.List;
import cl.duoc.AerolineaLaser.domain.Usuario;
/**
 *
 * @author Angy
 */
public interface UsuarioService {
    public List<Usuario> listarUsuarios();
    
    public void guardar(Usuario usuario);
    
    public void eliminar(Usuario usuario);
    
    public Usuario encontrarUsuario(Usuario usuario);
    

}
