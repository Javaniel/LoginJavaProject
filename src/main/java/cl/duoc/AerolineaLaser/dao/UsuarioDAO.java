/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.AerolineaLaser.dao;

import org.springframework.data.repository.CrudRepository;
import cl.duoc.AerolineaLaser.domain.Usuario;
/**
 *
 * @author Angy
 */
public interface UsuarioDAO  extends CrudRepository<Usuario,Long>{
    
}
