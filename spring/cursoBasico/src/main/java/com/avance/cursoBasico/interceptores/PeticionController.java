package com.avance.cursoBasico.interceptores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inter")
public class PeticionController {

    @GetMapping("/foo")
    public ResponseEntity<String> foo() {
        return ResponseEntity.ok("Foo");
    }


    @GetMapping("/foo/{id}")
    public ResponseEntity<String> fooController(@PathVariable  Long id) {
        return ResponseEntity.ok("hello" + id );
    }


}
