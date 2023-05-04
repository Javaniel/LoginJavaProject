
package cl.duoc.AerolineaLaser.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Angy
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{ 
    
    @Override
    /*
    Acá estas cumpliendo una función del Servlet que nos decia a que ruta debía ir dependiendo de:
    */
    
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");//Definir cada vista de mi pagina
        registro.addViewController("/login");
        registro.addViewController("/servicioturismo").setViewName("servicioturismo");
        registro.addViewController("/serviciopremium").setViewName("serviciopremium");
        registro.addViewController("/logout").setViewName("logout");

    }
}

