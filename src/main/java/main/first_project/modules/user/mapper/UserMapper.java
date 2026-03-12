package main.first_project.modules.user.mapper;

import main.first_project.common.RowMapper;
import main.first_project.modules.user.dto.*;
import main.first_project.modules.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends RowMapper<User, UserDTO> {
}
