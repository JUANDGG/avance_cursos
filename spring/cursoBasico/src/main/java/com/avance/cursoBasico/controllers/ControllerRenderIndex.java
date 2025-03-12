package com.avance.cursoBasico.controllers;



import com.avance.cursoBasico.pojo.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/*
* Se usa para aplicaciones web tradicionales (MVC) que devuelven vistas HTML.
No convierte automáticamente las respuestas a JSON.
Normalmente se usa con @GetMapping, @PostMapping, y se combina con Model o ModelAndView para enviar datos a la vista.

* */
@Controller
@RequestMapping("/users")
public class ControllerRenderIndex {
    //se puede hacer aca
//    @Value("${uri-example}")
//    private String uri;

    //Esto es lo mismo que arriba
     @Autowired
    private Environment environment;


    @ModelAttribute("users")
    public List<UserDto> fetchinUsers (){
        WebClient webClient = WebClient.builder().baseUrl("http://localhost:8081").build();
        // Asegurarse de recibir una LISTA y no un MAP
        //usando model attribute users se guarda en la lista pero de thymyleaf
        List<UserDto> users = webClient.get()
                .uri("/api/v1/return/users")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<UserDto>>() {})
                .block();

        return users ;
    }



    @GetMapping
    public String getIndex(Model model,@Value("${uri-example}") String uri) {
        //cuando se inyecta Environment en la clase se puede acceder a cualquier propiedad de configuración
        //environment.getProperty("uri-example");
        model.addAttribute("title",uri );
        return "index";
    }


    @GetMapping("/email")
    //el required del request param es que el usuario si o si tiene que para entrar ala ruta tiene que hacer es primero parsarle el requestparam
    //por lo que por defecto es true  pero si lo ponemos en false no seria nesesario
    //el request param puede tener varios parametros
    public String renderYourName(@RequestParam(required = false) String email , Model model) {
        if(email == null) {
            return "404";
        }

        var users = fetchinUsers();
        UserDto user = fetchinUsers().stream().filter(e -> e.getEmail().equalsIgnoreCase(email.trim())).findFirst().orElse(null);

        model.addAttribute("title", "avance");
        if(user == null) {
            model.addAttribute("email", "el  usuario no existe en la base de datos");
        }
        else {
            model.addAttribute("email", email);
        }

        return "renderYourName";
    }


//    @GetMapping("/urlEjemplo")
//    //el request param puede tener varios parametro
//    quedaria asi http:/dominio/urlEJemplo?email=elEmail&name =juan
//    public String renderYourName(@RequestParam(required = false) String email , @RequestParam String name) {
//        return  respuesta
//    }

    @GetMapping("/url")
    //el request param puede tener varios parametro
    public String formaNativa(HttpServletRequest request, Map<String ,Object> model) {
        model.put("title", "avance");
        model.put("name", request.getParameter("name"));
        return "ejemplo";
    }


    //    @GetMapping("/url{email}/{juan}")
    //    multiples path variable
    //    quedaria asi http:/dominio/urlEJemplo?email=elEmail&name =juan
    //    public String renderYourName(@PathVariable String email , @PathVariable String name) {
    //        return  respuesta
    //    }

    //esta es una forma de decir que a cualquiera de esas rutas se puede haceder
    @GetMapping({"/r", "redirect","redirection"})
    public String redirect() {
        //Con redirect
        //aca siempre redirige ala ruta no al template osea que cambia la ruta
        //return "redirect:/users";


        //Con forward
        //con este no cambiaria la ruta
        return "forward:/users";
    }
}
