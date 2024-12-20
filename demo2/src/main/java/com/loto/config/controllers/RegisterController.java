package com.loto.config.controllers;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute User user) {
        userService.save(user); // Enregistre l'utilisateur dans la base de données
        return "redirect:/login?registered=true";
    }
