package com.loto.services;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user); // Enregistre l'utilisateur dans la base de données
    }
}

