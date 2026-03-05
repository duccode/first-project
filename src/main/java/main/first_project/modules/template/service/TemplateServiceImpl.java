package main.first_project.modules.template.service;


import main.first_project.exception.NotFoundException;
import main.first_project.modules.template.dto.TemplateRequest;
import main.first_project.modules.template.dto.TemplateResponse;
import main.first_project.modules.template.entity.Template;
import main.first_project.modules.template.mapper.TemplateMapper;
import main.first_project.modules.template.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;

    public TemplateServiceImpl(TemplateRepository templateRepository){
        this.templateRepository = templateRepository;
    }

    @Override
    public List<TemplateResponse> getAll(){
        return templateRepository.findAll()
                .stream()
                .map(TemplateMapper::toDTO)
                .toList();
    }

    @Override
    public TemplateResponse create(TemplateRequest request){

        Template bot = TemplateMapper.toEntity(request);

        Template saved = templateRepository.save(bot);

        return TemplateMapper.toDTO(saved);
    }

    @Override
    public TemplateResponse getById(Long id){
        Template bot = templateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Bot not found"));
        return TemplateMapper.toDTO(bot);
    }

}
