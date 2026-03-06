package main.first_project.modules.template.dto;

import lombok.Data;


@Data
public class TemplateRequest {

    private Long Id;
    private Long botId;
    private String name;
    private Long categoryId;
    private String type;
    private String content;
}
