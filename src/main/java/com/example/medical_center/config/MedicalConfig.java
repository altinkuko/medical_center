package com.example.medical_center.config;

import com.example.medical_center.dao.User;
import com.example.medical_center.repositories.UserRepository;
import com.example.medical_center.static_data.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@RequiredArgsConstructor
public class MedicalConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = User.builder()
                    .role(Role.ROLE_ADMIN)
                    .username("admin")
                    .build();
            userRepository.save(user);
            System.out.println("U kry");
        }
    }
}
