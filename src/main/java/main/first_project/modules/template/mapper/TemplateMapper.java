package main.first_project.modules.template.mapper;

import main.first_project.common.RowMapper;
import main.first_project.modules.template.dto.TemplateDTO;
import main.first_project.modules.template.entity.Template;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TemplateMapper extends RowMapper<Template, TemplateDTO> {
}
