package com.example.medical_center.config;

import com.example.medical_center.dao.User;
import com.example.medical_center.repositories.UserRepository;
import com.example.medical_center.static_data.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class MedicalConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    @Value("${profile.message}")
    private String message;
    @Override
    public void run(String... args) {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = User.builder()
                    .role(Role.ROLE_ADMIN)
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .active(true)
                    .email("test@test.com")
                    .name("Administrator")
                    .build();
            userRepository.save(user);
            System.out.println("U kry");
        }
        System.out.println(message);
    }

//
//    @Bean
//    @Scope("singleton")
//    Singleton per te deklaruar qe nje bean inicializohet vetem nje here
//    @Scope("prototype")
//    Prototype per te deklaruar qe nje bean inicializohet e re sa here qe thirret
//    @SessionScope perdoret per te deklaruar qe nje bean krijohet per nje user session dhe shkaterohet kur sessioni mbyllet
//    @RequestScope perdoret per te krijuar nje bean per cdo kerkese Http dhe shkaterohet ne fund te saj
//    @ApplicationScope eshte njelloj si singleton pra qe nje bean persist gjate gjithe jetes se applikacionit
//    WebSocket perdoret kur komunikon brenda nje TCP te caktuar ne kohe reale
}
