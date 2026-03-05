package main.first_project.modules.user.dto;

import lombok.Data;

@Data
public class UserResponse {

    private Long id;
    private String username;
    private String email;
}
