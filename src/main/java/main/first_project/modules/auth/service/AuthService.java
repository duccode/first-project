package main.first_project.modules.auth.service;


import main.first_project.modules.user.dto.UserDTO;

public interface AuthService {
    String login(String email, String password);
}
