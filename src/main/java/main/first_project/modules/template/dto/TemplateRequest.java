package main.first_project.modules.template.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TemplateRequest {

    private Long adminId;
    private String viewName;
    private String urlAddFriend;
    private Integer planType;
    private LocalDateTime expiredDate;
    private Integer billStatus;
}
