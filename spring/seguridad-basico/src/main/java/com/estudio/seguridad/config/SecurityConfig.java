package com.estudio.seguridad.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


//la anotacion configuration es un contenedor de beans
@Configuration
//con esta anotacion le decimos a sprring  security que vamos a configurar la seguridad de nuestra aplicacion
//@EnableWebSecurity
public class SecurityConfig {
    @Bean
    /*la security flite chain es una interfaz que lo que tiene 2 cosas , una metodo que retorna 
    un booleano y otro que retorna una lista
    */
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity)  throws Exception{

        return
                httpSecurity
                        //esto es una vulnerabilidad para las aplicaciones web cuando trabajamos con formularios osea para aplicaciones con thymylead o jsp
                        //por eso lo desabilitamos por que vamos a usar un servicio rest y no vamos a utilizar formularios
                        .csrf(csrf -> csrf.disable())

                        //con este metodo le pasamos las rutas que queremos proteger o permitir el asseso sin autorizacion como tal
                        .authorizeHttpRequests(path -> 
                            path.requestMatchers("/api/sin-seguridad")
                            .permitAll()
                            .anyRequest()
                            .authenticated()
                        )
                        //para habilitar el login de spring security el del front end
                        .formLogin(form -> 
                            form.successHandler(authenticationSuccessHandler()) //url donde se va a ir despues de que se tenga exito en la seccion
                            .permitAll()
                            
                            )   
                        //le decimos que vamos a usar la autenticacion basica osea usuario y contraseña esto normalmente se envia en los headers de la peticiones
                        //esto se usa cuando la seguridad no es tan importante
                        //enviar las credenciales en el header de la aplicacion no seria lo ideal
                        .httpBasic(http ->http.disable())
                        
                        //con esto configuramos la sesion del usuario : la seccion es un object en memoria
                        //ALWAYS : crea una sesion si no existe si ya hay una seccion existente la reutiliza
                        //IF_REQUIRED : crea una sesion si es necesario
                        //STATELESS : no crea ningunauna sesion si no que cada solicitut es independiente
                        //NEVER : no crea una sesion pero si ya existe la reutiliza
                        .sessionManagement(s -> s
                            .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // Crea sesión siempre
                            /* 
                             * cuando se crea una nueva sesión, se genera un id de seccion
                             * la fijación de sesiones es un ataque en el que un atacante crea una sesión y la fija a un usuario
                             * y se hace pasar por el usuario
                             */


                             /* 
                                - migrateSeccion() : cuando se dectecta que se esta intentando fijar una sesion
                                * se crea una nueva sesion y se copian los atributos de la sesion anterior osea va registrar otro id de seccion distinto 
                                del que tien el atacante

                                - newSeccion() :creaa una nueva sesion sin los atributos de la sesion anterior

                                - none() : inabilita la proteccion contra la fijacion de sesion

                              */


                              .sessionFixation().migrateSession() // Protege contra ataques de fijación de sesión
                              .sessionConcurrency(concurrency -> concurrency
                                      .maximumSessions(1) // Solo una sesión por usuario
                                      .expiredUrl("/home") // Redirección si la sesión expira
                                      .sessionRegistry(sessionRegistry())
                                      
                              )

                              
                            
                        )
                        
                   
                    
        
                        //.httpBasic(basic ->)  
                        .build();
        
    }

    @Bean
    public SessionRegistry sessionRegistry (){
        return new SessionRegistryImpl() ;
    }

    //este es el manejador de autheticacion se se tuvo exito en la autenticacion
    public AuthenticationSuccessHandler authenticationSuccessHandler() {
        return ((request ,response, authentication) -> {
            response.sendRedirect("api/details-session");
        });
    }

    
    
}
