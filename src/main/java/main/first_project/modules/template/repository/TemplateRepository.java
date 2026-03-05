package main.first_project.modules.template.repository;

import main.first_project.modules.template.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, Long> {

}
