package main.first_project.modules.user.service;

import main.first_project.modules.user.dto.UserRequest;
import main.first_project.modules.user.dto.UserResponse;
import main.first_project.user.dto.*;

import java.util.List;


public interface UserService {

    List<UserResponse> getAll();

    UserResponse create(UserRequest request);
    UserResponse getById(Long id);
}
