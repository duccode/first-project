package main.first_project.modules.template.repository;

import main.first_project.modules.template.entity.TmpButton;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TmpButtonRepository extends JpaRepository<TmpButton, Long> {

    List<TmpButton> findByTemplateId(Long templateId);
}
