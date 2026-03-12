package main.first_project.modules.user.service;

import main.first_project.modules.user.dto.*;

import java.util.List;


public interface UserService {

    List<UserDTO> getAll();

    UserDTO create(UserDTO request);
    UserDTO getById(Long id);
}
