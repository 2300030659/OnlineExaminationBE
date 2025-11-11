// UserController.java
package com.onlineexam.online_exam_backend.controller;

import com.onlineexam.online_exam_backend.model.User;
import com.onlineexam.online_exam_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        String msg = userService.register(user);
        if ("Email already exists".equals(msg)) {
            return ResponseEntity.badRequest().body(Map.of("msg", msg));
        }
        return ResponseEntity.ok(Map.of("msg", msg));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        return userService.login(email, password)
                .map(user -> ResponseEntity.ok(Map.of(
                        "msg", "Login successful",
                        "user", Map.of(
                                "id", user.getId(),
                                "name", user.getName(),
                                "email", user.getEmail(),
                                "role", user.getRole()
                        )
                )))
                .orElseGet(() -> ResponseEntity.status(401).body(Map.of("msg", "Invalid email or password")));
    }
}
