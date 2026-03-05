package main.first_project.user.service;

import main.first_project.user.dto.*;
import main.first_project.user.entity.User;

import java.util.List;


public interface UserService {

    List<UserResponse> getAll();

    UserResponse create(UserRequest request);
    UserResponse getById(Long id);
}
