package main.first_project.modules.template.mapper;

import main.first_project.modules.template.dto.TmpButtonDTO;
import main.first_project.modules.template.entity.TmpButton;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TmpButtonMapper extends  RowMapper<TmpButton, TmpButtonDTO>{
}
