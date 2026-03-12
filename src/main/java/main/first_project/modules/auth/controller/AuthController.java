package main.first_project.modules.auth.controller;

import lombok.RequiredArgsConstructor;
import main.first_project.modules.auth.service.AuthService;
import main.first_project.modules.user.dto.UserDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public String login(@RequestBody UserDTO request){

        return authService.login(
                request.getEmail(),
                request.getPassword()
        );
    }
}
