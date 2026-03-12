package main.first_project.modules.user.service;


import main.first_project.exception.NotFoundException;
import main.first_project.modules.user.dto.UserDTO;
import main.first_project.modules.user.entity.User;
import main.first_project.modules.user.mapper.UserMapper;
import main.first_project.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAll(){
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDTO)
                .toList();
    }

    @Override
    public UserDTO create(UserDTO request){

        User user = userMapper.toEntity(request);

        User saved = userRepository.save(user);

        return userMapper.toDTO(saved);
    }

    @Override
    public UserDTO getById(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
        return userMapper.toDTO(user);
    }

}
