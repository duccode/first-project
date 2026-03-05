package main.first_project.modules.template.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import main.first_project.common.BaseEntity;

@Entity
@Getter
@Setter
@Table(name = "buttons")
public class Button extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
