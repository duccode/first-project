package main.first_project.user.entity;

import jakarta.persistence.*;
import lombok.*;
import main.first_project.common.BaseEntity;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;
}
