package br.com.murilo.artgalley.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Funcionou");
    }

    @GetMapping("/context")
    public void getContext() {
        final SecurityContext context = SecurityContextHolder.getContext();
        System.out.println(context);
    }
}
