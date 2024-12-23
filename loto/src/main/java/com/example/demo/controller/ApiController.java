package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    // Accessible uniquement par les administrateurs
    @GetMapping("/admin")
    public String adminEndpoint() {
        return "Bienvenue, Administrateur!";
    }

    // Accessible par tous les utilisateurs authentifiés
    @GetMapping("/user")
    public String userEndpoint() {
        return "Bienvenue, Utilisateur!";
    }

	@GetMapping
    public String getAllUsers() {
        return "Liste des utilisateurs";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        return "Utilisateur avec ID : " + id;
    }
}
