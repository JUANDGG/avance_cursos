package com.avance.cursoBasico.interceptores.ejemploBasico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

@RestController
@RequestMapping("/api/v1/courses")
public class GetCoursesController {
    @Autowired
    private Map<String ,Map<String,String>> data ;



    @GetMapping("/{id}")
    public Map<String ,Map<String,String>> getCourses(@PathVariable("id") Long id) {
        return data;
    }
}
