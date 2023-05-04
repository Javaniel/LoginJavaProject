
package cl.duoc.AerolineaLaser.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 *
 * @author Angy
 */

@Configuration //Debo decirle que es un archivo de configuracion
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override //sobre escribir para reconfigurar nuestra aplicación
    protected void configure(AuthenticationManagerBuilder auth) //Nos permite crear usuarios en memoria
        //me va a crear usuarios en memoria para probar, todavía no en BDD
                throws Exception{ 
                auth.inMemoryAuthentication()
                .withUser("admin") //nombre del usuario
                .password("{noop}123") //Noop=no encriptada
                .roles("ADMIN","USERPRE", "USERTUR") //
                /**Admin tiene contorl sobre todo y además es un usuario.
                User, tiene el permiso restirngido**/
                .and()
                .withUser("userpre")
                .password("{noop}123")
                .roles("USERPRE")
                .and()
                .withUser("usertur")
                .password("{noop}123")
                .roles("USERTUR");
    }
        
        /**Método para restirngir el ingreso a páginas del rol de mis usuarios**/
        @Override
        protected void configure(HttpSecurity http) 
                throws Exception{ //  
        //quienes pueden acceder a que cosa?
        http.authorizeRequests() //me ayuda a autorizar las peticioens que hagan los usuarios a la pagina web= ingresar a ciertas páginas.
                .antMatchers("/servicioturismo", "/serviciopremium") //Estas páginas solo la van a poder 
                .hasRole("ADMIN") //El Admin
               // .antMatchers("/servicioturismo", "/login", "/logout")//Todas estas páginas las va a poder ver el...
                .antMatchers("/")
                .hasAnyRole("USERTUR","ADMIN","USERTUR") //Usertur
                .antMatchers("/serviciopremium")//Todas estas páginas las va a poder ver el...
                .hasRole("USERPRE") //Userpre
                .antMatchers("/servicioturismo")//Todas estas páginas las va a poder ver el...
                .hasRole("USERTUR") //Userpre
                .and()/**Todo esto pasa de acuerdo a un **/
                .formLogin()//porque tengo que decirle desde donde voy a ingresar
                    .loginPage("/login") //en mi página de login que estoy designando
                .and()
                .logout()
                .logoutSuccessUrl("/login") //-
                .and()
                .exceptionHandling().accessDeniedPage("/login")
                ;
        }                
    }

