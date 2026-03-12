package main.first_project.modules.auth.service;


import main.first_project.modules.auth.dto.AuthDTO;
import main.first_project.modules.user.dto.UserDTO;

public interface AuthService {
    AuthDTO login(String email, String password);
}
