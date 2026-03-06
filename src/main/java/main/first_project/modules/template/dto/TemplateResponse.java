package main.first_project.modules.template.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TemplateResponse {

    private Long Id;
    private Long botId;
    private String name;
    private Long categoryId;
    private String type;
    private String content;
    private Integer inPark;
    List<TmpButtonDTO> tmpButtonDTOList;
}
