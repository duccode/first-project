package main.first_project.modules.bot.controller;

import main.first_project.common.ApiResponse;
import main.first_project.modules.bot.dto.BotRequest;
import main.first_project.modules.bot.dto.BotResponse;
import main.first_project.modules.bot.service.BotService;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/bots")
public class BotController {

    private final BotService botService;

    public BotController(BotService userService){
        this.botService = userService;
    }

    @GetMapping
    public ApiResponse<List<BotResponse>> getAll(){
        List<BotResponse> listUser = botService.getAll();

        ApiResponse<List<BotResponse>> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(listUser);
        response.setMessage("success");
        return response;
    }

    @PostMapping
    public BotResponse create(@RequestBody BotRequest request){
        return botService.create(request);
    }

    @GetMapping("/{id}")
    public ApiResponse<BotResponse> getById(@PathVariable Long id){
        BotResponse user = botService.getById(id);
        ApiResponse<BotResponse> response = new ApiResponse<>();
        response.setSuccess(true);
        response.setData(user);
        response.setMessage("success");
        return response;
    }
}
