// UserRepository.java
package com.onlineexam.online_exam_backend.repository;

import com.onlineexam.online_exam_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
