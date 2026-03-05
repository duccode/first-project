package main.first_project.modules.template.repository;

import main.first_project.modules.template.entity.Button;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ButtonRepository extends JpaRepository<Button, Long> {


}
