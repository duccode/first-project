package main.first_project.modules.template.controller;

import main.first_project.common.ApiResponse;
import main.first_project.modules.template.dto.TemplateRequest;
import main.first_project.modules.template.dto.TemplateResponse;
import main.first_project.modules.template.service.TemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/template")
public class TemplateController {

    private final TemplateService botService;

    public TemplateController(TemplateService userService){
        this.botService = userService;
    }

    @GetMapping
    public ApiResponse<List<TemplateResponse>> getAll(){
        List<TemplateResponse> listUser = botService.getAll();

        ApiResponse<List<TemplateResponse>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(listUser);
        response.setMessage("success");
        return response;
    }

    @PostMapping
    public TemplateResponse create(@RequestBody TemplateRequest request){
        return botService.create(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<TemplateResponse> getById(@PathVariable Long id){
        TemplateResponse user = botService.getById(id);
        ApiResponse<TemplateResponse> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(user);
        response.setMessage("success");
        return response;
    }
}
