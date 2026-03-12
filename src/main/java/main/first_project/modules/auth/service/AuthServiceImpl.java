package main.first_project.modules.auth.service;

import lombok.RequiredArgsConstructor;
import main.first_project.exception.NotFoundException;
import main.first_project.modules.auth.dto.AuthDTO;
import main.first_project.modules.user.dto.UserDTO;
import main.first_project.modules.user.entity.User;
import main.first_project.modules.user.repository.UserRepository;
import main.first_project.modules.user.service.UserService;
import main.first_project.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public AuthDTO login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        String token = JwtUtil.generateToken(user.getEmail());
        AuthDTO authDTO = new AuthDTO();
        authDTO.setToken(token);
        authDTO.setType("Bearer");
        authDTO.setExpired(86400000L);

        return authDTO;
    }
}
