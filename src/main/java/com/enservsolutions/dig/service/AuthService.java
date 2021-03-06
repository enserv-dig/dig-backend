package com.enservsolutions.dig.service;

import com.enservsolutions.dig.dto.RegisterRequest;
import com.enservsolutions.dig.entity.Client;
import com.enservsolutions.dig.entity.User;
import com.enservsolutions.dig.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final ClientService clientService;

    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(true);
        user.setAvatar(Integer.toString((int) Math.floor(Math.random()*10+1)));

        Optional<Client> client = clientService.getClient(registerRequest.getClientId());
        if(client.isPresent()) {
            user.setClient(client.get());
        }

        userRepository.save(user);
    }
}
