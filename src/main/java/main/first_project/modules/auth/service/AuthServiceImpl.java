package main.first_project.modules.auth.service;

import lombok.RequiredArgsConstructor;
import main.first_project.exception.NotFoundException;
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
    public String login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return JwtUtil.generateToken(user.getEmail());
    }
}
