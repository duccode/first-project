package main.first_project.user.service;


import main.first_project.exception.NotFoundException;
import main.first_project.user.dto.UserRequest;
import main.first_project.user.dto.UserResponse;
import main.first_project.user.entity.User;
import main.first_project.user.mapper.UserMapper;
import main.first_project.user.repository.UserRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAll(){
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .toList();
    }

    @Override
    public UserResponse create(UserRequest request){

        User user = UserMapper.toEntity(request);

        User saved = userRepository.save(user);

        return UserMapper.toDTO(saved);
    }

    @Override
    public UserResponse getById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return UserMapper.toDTO(user);
    }

}
