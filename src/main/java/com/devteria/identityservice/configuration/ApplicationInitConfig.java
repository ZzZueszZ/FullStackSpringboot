package com.devteria.identityservice.configuration;

import com.devteria.identityservice.entity.User;
import com.devteria.identityservice.enums.Role;
import com.devteria.identityservice.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class ApplicationInitConfig {

    PasswordEncoder passwordEncoder;

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository)
    {
        return args -> {

            if (userRepository.findByUsername("admin").isEmpty()){
                Set<String> roles = new HashSet<>();
                roles.add(Role.ADMIN.name());
                roles.add(Role.USER.name());

               User user = User.builder()
                       .username("admin")
                       .password(passwordEncoder.encode("admin"))
                       .roles(roles)
                       .build();
               userRepository.save(user);

            }

        };
    }
}
