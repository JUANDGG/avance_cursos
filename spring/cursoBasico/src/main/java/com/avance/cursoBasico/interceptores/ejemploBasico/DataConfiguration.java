package com.avance.cursoBasico.interceptores.ejemploBasico;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataConfiguration {
    @Bean
    public Map<String, Map<String, String>> loadData() {
        Map<String, Map<String, String>> data = new HashMap<>();

        // Crear un mapa interno antes de agregarlo
        Map<String, String> userData = new HashMap<>();
        userData.put("juan", "guiza");

        data.put("1", userData);

        return data; // Retornar el Map
    }

}
