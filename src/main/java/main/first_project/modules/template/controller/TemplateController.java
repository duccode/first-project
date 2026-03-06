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

    private final TemplateService templateService;

    public TemplateController(TemplateService templateService){
        this.templateService = templateService;
    }

    @GetMapping
    public ApiResponse<List<TemplateResponse>> getAll(){
        List<TemplateResponse> listUser = templateService.getAll();

        ApiResponse<List<TemplateResponse>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(listUser);
        response.setMessage("success");
        return response;
    }

    @PostMapping
    public TemplateResponse create(@RequestBody TemplateRequest request){
        return templateService.create(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<TemplateResponse> getById(@PathVariable Long id){
        TemplateResponse template = templateService.getById(id);
        ApiResponse<TemplateResponse> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(template);
        response.setMessage("success");
        return response;
    }

    @GetMapping("/list")
    public ApiResponse<List<TemplateResponse>> getListByBotId(@RequestParam Long botId){
        List<TemplateResponse> listTemplate = templateService.getByBotId(botId);
        ApiResponse<List<TemplateResponse>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(listTemplate);
        response.setMessage("success");
        return response;
    }
}
