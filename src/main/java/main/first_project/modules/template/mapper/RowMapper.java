package main.first_project.modules.template.mapper;

import main.first_project.modules.template.dto.TmpButtonDTO;
import main.first_project.modules.template.entity.TmpButton;

public interface RowMapper<E,D> {
    D toDTO(E entity);
    E toEntity(D dto);
}
