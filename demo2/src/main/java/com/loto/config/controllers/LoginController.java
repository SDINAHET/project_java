package com.loto.config.controllers;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Retourne le fichier login.html dans src/main/resources/templates
    }
}
