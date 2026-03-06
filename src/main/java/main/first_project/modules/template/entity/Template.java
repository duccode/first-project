package main.first_project.modules.template.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import main.first_project.common.BaseEntity;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "template")
public class Template extends BaseEntity {

    @Column(name = "bot_id")
    private Long botId;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "type")
    private String type;

    @Column(name = "content")
    private String content;

}
