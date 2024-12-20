package com.loto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "index"; // Correspond au fichier templates/index.html
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Correspond au fichier templates/login.html
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // Correspond au fichier templates/register.html
    }
}
