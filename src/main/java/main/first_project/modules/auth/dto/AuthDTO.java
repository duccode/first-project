package main.first_project.modules.auth.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthDTO {
    private String token;
    private String type;
    private Long expired;
}
