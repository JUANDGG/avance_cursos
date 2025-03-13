package com.estudio.seguridad.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class SeguridadController {

    @Autowired
    private SessionRegistry sessionRegistry;

 

    @GetMapping("/seguridad")
    public String seguridad() {
        return "Seguridad activa";
    }


    @GetMapping("/sin-seguridad")
    public String sinSeguridad() {
        return "Seguridad desactivada";
    }


    @GetMapping("/details-session")
    public ResponseEntity<?> getDetailSeccion(){
        String sessionId = null ;
        User user = null;

        List<Object> principals = sessionRegistry.getAllPrincipals();
        for (Object principal : principals) {
            if (principal instanceof User) {
                user = (User) principal;
                
            }

            // aca obtendriamos la lista de secciones
            //en este caso solo obtendremos la primera seccion , le decimos que  no incluya la sessiones expiradas
            List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(principal, false);
            for(SessionInformation e : sessionInformations){
                sessionId = e.getSessionId();
                break ;
            }
            
        }

        Map<String,Object> response = new HashMap<>();
        response.put("sessionId", sessionId);
        response.put("user", user);
        return ResponseEntity.status(HttpStatus.OK).body(response);


    }
}