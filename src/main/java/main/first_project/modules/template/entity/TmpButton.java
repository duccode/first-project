package main.first_project.modules.template.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import main.first_project.common.BaseEntity;

@Entity
@Getter
@Setter
@Table(name = "tmp_button")

public class TmpButton extends BaseEntity {

    @Column(name = "template_id")
    private Long templateId;

    @Column(name = "title")
    private String title;

    @Column(name = "text")
    private String text;

    @Column(name = "img_path")
    private String imgPath;


}
