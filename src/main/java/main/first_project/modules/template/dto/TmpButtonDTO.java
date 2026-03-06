package main.first_project.modules.template.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TmpButtonDTO {

    private Long templateId;
    private String title;
    private String text;
    private String imgPath;

}
