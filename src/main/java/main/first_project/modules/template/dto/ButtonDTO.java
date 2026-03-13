package main.first_project.modules.template.dto;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ButtonDTO {

    private Long buttonId;

    private Integer buttonNumber;

    private Integer postBack;

    private Integer method;

    private String label;

    private String data;

    private Integer scenario;

    private Integer tag;

    private Integer eventTimeId;
}
