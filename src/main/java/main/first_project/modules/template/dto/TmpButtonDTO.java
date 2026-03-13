package main.first_project.modules.template.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TmpButtonDTO {
    private Long id;
    private Long templateId;
    private String title;
    private String text;
    private String imgPath;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<ButtonDTO> listButtonDTO;

}
