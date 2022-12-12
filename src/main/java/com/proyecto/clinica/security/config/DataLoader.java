package com.proyecto.clinica.security.config;

import com.proyecto.clinica.entity.AppUser;
import com.proyecto.clinica.entity.AppUserRole;
import com.proyecto.clinica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        userRepository.save(new AppUser("User", "pass", "userTest@digital.com",
                hashedPassword, AppUserRole.USER));
    }
}
