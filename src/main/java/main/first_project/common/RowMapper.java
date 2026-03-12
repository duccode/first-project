package main.first_project.common;

import main.first_project.modules.user.dto.UserDTO;

import java.util.List;

public interface RowMapper<E,D> {
    D toDTO(E entity);
    E toEntity(D dto);

    List<D> toDTOList(List<E> entities);
    List<E> toEntityList(List<D> dtos);
}
