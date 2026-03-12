package main.first_project.modules.user.controller;

import java.util.List;

import main.first_project.common.ApiResponse;
import main.first_project.modules.user.dto.UserDTO;
import main.first_project.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ApiResponse<List<UserDTO>> getAll(){
        List<UserDTO> listUser = userService.getAll();
        return new ApiResponse<>(true,listUser,"success");
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO request){
        return userService.create(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserDTO> getById(@PathVariable Long id){
        UserDTO user = userService.getById(id);

        return new ApiResponse<>(true,user,"success");
    }
}
