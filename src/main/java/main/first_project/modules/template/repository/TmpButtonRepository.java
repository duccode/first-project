package main.first_project.modules.template.repository;

import main.first_project.modules.template.entity.TmpButton;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TmpButtonRepository extends JpaRepository<TmpButton, Long> {


}
