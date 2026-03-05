package main.first_project.user.controller;

import java.util.List;

import main.first_project.common.ApiResponse;
import main.first_project.user.dto.UserRequest;
import main.first_project.user.dto.UserResponse;
import main.first_project.user.service.UserService;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAll(){
        List<UserResponse> listUser = userService.getAll();

        ApiResponse<List<UserResponse>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(listUser);
        response.setMessage("success");
        return response;
    }

    @PostMapping
    public UserResponse create(@RequestBody UserRequest request){
        return userService.create(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getById(@PathVariable Long id){
        UserResponse user = userService.getById(id);
        ApiResponse<UserResponse> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(user);
        response.setMessage("success");
        return response;
    }
}
