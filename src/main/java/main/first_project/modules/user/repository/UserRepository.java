package main.first_project.modules.user.repository;

import main.first_project.modules.user.dto.UserDTO;
import main.first_project.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
