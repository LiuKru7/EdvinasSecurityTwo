package com.liu.EdvinasSecurityTwo.auth.config;

import com.liu.EdvinasSecurityTwo.auth.enums.Role;
import com.liu.EdvinasSecurityTwo.auth.model.User;
import com.liu.EdvinasSecurityTwo.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component("authFakeDataLoader")
@RequiredArgsConstructor
public class FakeDataLoader implements CommandLineRunner {

    final private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        var user = User.builder()
                .role(Role.ROLE_ADMIN)
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .build();

        userRepository.save(user);
    }

}
