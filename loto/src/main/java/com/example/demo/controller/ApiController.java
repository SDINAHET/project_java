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

	@PostMapping("/users")
	public String createUser() {
		return "Utilisateur créé";
	}

	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable String id) {
		return "Utilisateur supprimé";
	}

	@PutMapping("/users/{id}")
	public String updateUser(@PathVariable String id) {
		return "Utilisateur mis à jour";
	}

	// @PostMapping("/admin")
	// public String createUser() {
	// 	return "Utilisateur créé";
	// }

	// @DeleteMapping("/admin/{id}")
	// public String deleteUser(@PathVariable String id) {
	// 	return "Utilisateur supprimé";
	// }

	// @PutMapping("/admin/{id}")
	// public String updateUser(@PathVariable String id) {
	// 	return "Utilisateur mis à jour";
	// }

	@GetMapping("/admin/{id}")
    public String getAllUsers() {
        return "Liste des utilisateurs";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable String id) {
        return "Utilisateur avec ID : " + id;
    }

	@RestController
	public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Bienvenue sur la page d'accueil !";
        // return "index"; // Le nom du fichier HTML sans l'extension
    }
}
}
