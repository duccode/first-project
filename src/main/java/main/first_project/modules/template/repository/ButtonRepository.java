package main.first_project.modules.template.repository;

import main.first_project.modules.template.dto.ButtonDTO;
import main.first_project.modules.template.entity.Button;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ButtonRepository extends JpaRepository<Button, Long> {
    List<Button> getListButtonByButtonId(Long buttonId);

}
