package com.onlineexam.online_exam_backend.service;

import com.onlineexam.online_exam_backend.model.User;
import com.onlineexam.online_exam_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String register(User user) {
        if (repo.findByEmail(user.getEmail()).isPresent()) {
            return "Email already exists";
        }
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "Signup successful";
    }

    public Optional<User> login(String email, String rawPassword) {
        Optional<User> user = repo.findByEmail(email);
        if (user.isPresent() && encoder.matches(rawPassword, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }
}
