package main.first_project.modules.template.controller;

import main.first_project.common.ApiResponse;
import main.first_project.modules.template.dto.TemplateDTO;
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
    public ApiResponse<List<TemplateDTO>> getAll(){
        List<TemplateDTO> templates = templateService.getAll();

        return new ApiResponse<>(true,templates,"success");
    }

    @PostMapping
    public TemplateDTO create(@RequestBody TemplateDTO request){
        return templateService.create(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<TemplateDTO> getById(@PathVariable Long id){
        TemplateDTO template = templateService.getById(id);
        return new ApiResponse<>(true,template,"success");
    }

    @GetMapping("/list")
    public ApiResponse<List<TemplateDTO>> getListByBotId(@RequestParam Long botId){
        List<TemplateDTO> listTemplate = templateService.getByBotId(botId);
        return new ApiResponse<>(true,listTemplate,"success");
    }
}
