package main.first_project.modules.user.entity;

import jakarta.persistence.*;
import lombok.*;
import main.first_project.common.BaseEntity;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends BaseEntity {

    private String username;

    private String email;
}
