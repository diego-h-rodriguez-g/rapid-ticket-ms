package com.dev.rapidticket.javastack.controller;

import com.dev.rapidticket.javastack.model.JavaStackResponse;
import com.dev.rapidticket.javastack.service.JavaStackService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JavaStackController {

    private final JavaStackService javaStackService;

    public JavaStackController(JavaStackService javaStackService) {
        this.javaStackService = javaStackService;
    }

    @GetMapping(path = "/v1/java-stack", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JavaStackResponse> getJavaStack() {
        return ResponseEntity.ok(javaStackService.getJavaStack());
    }
}
