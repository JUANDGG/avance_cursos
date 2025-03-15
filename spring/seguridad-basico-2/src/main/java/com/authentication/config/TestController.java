package com.authentication.config;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api")
//como habilitamos el enable web security se habilita anotaciones especiales que nos permiten configurar la seguridad pero con anotaciones
//@PreAuthorize("denyall()")
public class TestController {
    
    @GetMapping("/secured")
    public String secured() {
        return "secured controller";
    }
    
    //@PreAuthorize("permitAll()")
    //@PreAuthorize("hasAuthority("READ")")
    @GetMapping("/not-secured")
    public String notSecured() {
        return "NOT secured controller";
    }
}
