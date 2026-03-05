package main.first_project.modules.bot.service;


import main.first_project.exception.NotFoundException;
import main.first_project.modules.bot.dto.BotRequest;
import main.first_project.modules.bot.dto.BotResponse;
import main.first_project.modules.bot.entity.Bot;
import main.first_project.modules.bot.mapper.BotMapper;
import main.first_project.modules.bot.repository.BotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotServiceImpl implements BotService {
    private final BotRepository botRepository;

    public BotServiceImpl(BotRepository botRepository){
        this.botRepository = botRepository;
    }

    @Override
    public List<BotResponse> getAll(){
        return botRepository.findAll()
                .stream()
                .map(BotMapper::toDTO)
                .toList();
    }

    @Override
    public BotResponse create(BotRequest request){

        Bot bot = BotMapper.toEntity(request);

        Bot saved = botRepository.save(bot);

        return BotMapper.toDTO(saved);
    }

    @Override
    public BotResponse getById(Long id){
        Bot bot = botRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bot not found"));
        return BotMapper.toDTO(bot);
    }

}
