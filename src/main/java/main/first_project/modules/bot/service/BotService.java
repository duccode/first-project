package main.first_project.modules.bot.service;

import main.first_project.modules.bot.dto.BotRequest;
import main.first_project.modules.bot.dto.BotResponse;

import java.util.List;


public interface BotService {

    List<BotResponse> getAll();

    BotResponse create(BotRequest request);
    BotResponse getById(Long id);
}
