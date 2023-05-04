package cl.duoc.AerolineaLaser.web;

import cl.duoc.AerolineaLaser.dao.UsuarioDAO;
import cl.duoc.AerolineaLaser.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;//esta es la importación de la anotación @AuthenticationPrincipal 
import org.springframework.security.core.userdetails.User;//@AuthenticationPrincipal import/ NOTA: Recuerda que son los que dice CORE
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Angy
 */

@Controller //Controlador para hacer peticiones 
@Slf4j //Me permite colocar anotaciones
public class ControladorInicio {
    
    @Autowired
    private UsuarioService usuarioService;

 //Model es como trabajar con el HttpServletRequest y HttpServletReponse, pero esto está en una dependencia de Spring
/*@GetMapping("/")//esta es la url
    public String inicio(Model modelo){
       var usuarios=usuarioDAO.findAll();
       modelo.addAttribute("usuarios", usuarios);
       System.out.println(usuarios);
       return "login";   //este es el archivo
}*/
    
    @GetMapping("/")
    public String inicio(Model modelo, @AuthenticationPrincipal User user){
        String url = "";//inicializando la variable -Creo la variable de retorno. - Inicia etando vacia porque su valro toma en el if
        String rol = user.getAuthorities().toString();//Esta me lista todos los Roles que he creado 
        //contenedor ------- pelotas ----- .toString() Trayendoe l nombre de ese rol.
    
        if(rol.contains("ADMIN")){
            url = "/index";
        }else if(rol.contains("USERPRE")){
            url = "/serviciopremium";
        }else if(rol.contains("USERTUR")){
            url = "/servicioturismo";
        }
        return url;
    }
    @GetMapping("/logout")
    public String logout(Model modelo){
        return "logout";
    }
    
}
