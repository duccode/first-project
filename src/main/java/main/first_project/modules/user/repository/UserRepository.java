package main.first_project.modules.user.repository;

import main.first_project.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
