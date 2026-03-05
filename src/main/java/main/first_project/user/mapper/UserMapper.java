package main.first_project.user.mapper;

import main.first_project.user.dto.*;
import main.first_project.user.entity.User;

public class UserMapper {
    public static User toEntity(UserRequest request){
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        return user;
    }

    public static UserResponse toDTO(User user){
        UserResponse res = new UserResponse();
        res.setId(user.getId());
        res.setUsername(user.getUsername());
        res.setEmail(user.getEmail());
        return res;
    }
}
