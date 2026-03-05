package main.first_project.modules.user.service;

import main.first_project.modules.user.dto.*;

import java.util.List;


public interface UserService {

    List<UserResponse> getAll();

    UserResponse create(UserRequest request);
    UserResponse getById(Long id);
}
