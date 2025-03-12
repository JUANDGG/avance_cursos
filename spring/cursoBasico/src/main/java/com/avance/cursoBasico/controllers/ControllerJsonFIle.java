package com.avance.cursoBasico.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List ;
@RestController
@RequestMapping("/json-mapper")
public class ControllerJsonFIle {

    @Value("classpath:/data.json")
    //hacede a un recurso
    private Resource resource;


    @GetMapping
    public List<User> loadUsers() {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = resource.getInputStream()) {
            return mapper.readValue(inputStream, new TypeReference<List<User>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo JSON", e);
        }



    }

}
