package com.authentication.config;



import java.util.HashSet;
import java.util.Set;

import com.authentication.Application;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
//esta anotacion es para ya utilizar anotaciones propias de spring security
@EnableMethodSecurity
public class ConfigSecurity {



    
    


    
    @Bean
    public SecurityFilterChain segChain (HttpSecurity httpSecurity)throws Exception{
        return httpSecurity
            .csrf(c->c.disable())
            .httpBasic(Customizer.withDefaults())
            .sessionManagement(s ->s
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
             .authorizeHttpRequests(path ->path
                //configurar endpoint publicos
                .requestMatchers("api/not-secured").permitAll()
                //configurar endpoint privados
                .requestMatchers("api/secured").hasAnyAuthority("CREATE")
                //configurar endpoints no especificados
                .anyRequest()
                //es mas escritcto ya que indica cual endpont voy a permitir y cual no haci el usuario este authenticado no lo dejara accedder si no se espcifica
                .denyAll()              
            ) 
            .build();
    }

    
    
        
    

    //EL authentication manager lo debemos generar atravez de otro objecto que se llama authentication
    //configuration
    @Bean
    public  AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration)throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public UserDetailsService userDetailsService (){
        //use Details es una interfaz y User si es la clase como tal
        Set<UserDetails> users = new HashSet<>();
        PasswordEncoder encoder = passwordEncoder();

        users.add(
          User.withUsername("root")
            .password(encoder.encode("1234"))
            .roles("ADMIN")
            .authorities("READ","CREATE")
            .build() 
        );


        for(int i =0 ;i<10;i++){
            users.add(
                User.withUsername(""+ i)
                .password("123")
                .roles("USER")
                .authorities("READ")
                .build()
            );
        }


        return new InMemoryUserDetailsManager(users);
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        /**
         * @Deprecated
        *  
         */
        return NoOpPasswordEncoder.getInstance() ;
    }

   

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        return daoAuthenticationProvider;
    }

   
    

}
