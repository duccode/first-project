package main.first_project.modules.template.mapper;

import main.first_project.common.RowMapper;
import main.first_project.modules.template.dto.ButtonDTO;
import main.first_project.modules.template.entity.Button;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ButtonMapper extends RowMapper<Button, ButtonDTO> {
}
