package main.first_project.modules.template.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemplateDTO {
    private Long Id;
    private Long botId;
    private String name;
    private Long categoryId;
    private String type;
    private String content;
    private Integer inPark;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    List<TmpButtonDTO> tmpButtonDTOList;
}
