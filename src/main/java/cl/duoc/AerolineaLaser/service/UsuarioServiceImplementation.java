
package cl.duoc.AerolineaLaser.service;

import cl.duoc.AerolineaLaser.domain.Usuario;
import java.util.List;
import cl.duoc.AerolineaLaser.dao.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
        
/**
 *
 * @author Angy
 */
@Service
public class UsuarioServiceImplementation implements UsuarioService{
    
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly=true)
    public List<Usuario> listarUsuarios(){
        return(List<Usuario>)usuarioDAO.findAll();
    }
    
   
    @Override
    @Transactional 
    public void guardar(Usuario usuario) {
        usuarioDAO.save(usuario);
    }
    
     
    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }
    
    
    @Override
    @Transactional(readOnly=true)
    public Usuario encontrarUsuario(Usuario usuario) {
        return usuarioDAO.findById(usuario.getIdUsuario()).orElse(usuario);
    }
}

