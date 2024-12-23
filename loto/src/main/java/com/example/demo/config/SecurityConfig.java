package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Gestion des utilisateurs en mémoire
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin") // Administrateur
                        .password(passwordEncoder().encode("admin1234")) // Mot de passe sécurisé
                        .roles("ADMIN") // Rôle ADMIN
                        .build(),
                User.withUsername("user") // Utilisateur par défaut
                        .password(passwordEncoder().encode("user1234")) // Mot de passe sécurisé
                        .roles("USER") // Rôle USER
                        .build()
        );
    }

    // Encodeur de mots de passe avec BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configuration des règles de sécurité
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable() // Désactive CSRF (optionnel, à activer en production)
            .authorizeHttpRequests()
            .requestMatchers("/admin/**").hasRole("ADMIN") // Protège les routes /admin/** pour les ADMIN
            .requestMatchers("/login", "/static/**", "/").permitAll() // Autorise l'accès à /login et /
            .anyRequest().authenticated() // Toute autre route nécessite une authentification
            .and()
            .formLogin(); // Active un formulaire de connexion par défaut
            // .defaultSuccessUrl("/", true); // Redirige vers / après le login
        return http.build();
    }
}

