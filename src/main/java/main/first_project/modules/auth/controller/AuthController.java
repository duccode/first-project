package main.first_project.modules.auth.controller;

import lombok.RequiredArgsConstructor;
import main.first_project.common.ApiResponse;
import main.first_project.modules.auth.dto.AuthDTO;
import main.first_project.modules.auth.service.AuthService;
import main.first_project.modules.user.dto.UserDTO;
import main.first_project.modules.user.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ApiResponse<AuthDTO> login(@RequestBody UserDTO request){
        AuthDTO response = authService.login(
                request.getEmail(),
                request.getPassword()
        );

        return new ApiResponse<>(true, response, "success");
    }
}
