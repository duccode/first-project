package main.first_project.modules.template.service;


import main.first_project.exception.NotFoundException;
import main.first_project.modules.template.dto.TemplateRequest;
import main.first_project.modules.template.dto.TemplateResponse;
import main.first_project.modules.template.dto.TmpButtonDTO;
import main.first_project.modules.template.entity.Template;
import main.first_project.modules.template.entity.TmpButton;
import main.first_project.modules.template.mapper.TemplateMapper;
import main.first_project.modules.template.mapper.TmpButtonMapper;
import main.first_project.modules.template.repository.TemplateRepository;
import main.first_project.modules.template.repository.TmpButtonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;
    private final TmpButtonRepository tmpButtonRepository;
    @Autowired
    private TmpButtonMapper tmpButtonMapper;

    public TemplateServiceImpl(TemplateRepository templateRepository,TmpButtonRepository tmpButtonRepository,TmpButtonMapper tmpButtonMapper){
        this.templateRepository = templateRepository;
        this.tmpButtonRepository = tmpButtonRepository;
    }

    @Override
    public List<TemplateResponse> getAll(){
        return templateRepository.findAll()
                .stream()
                .map(TemplateMapper::toDTO)
                .toList();
    }

    @Override
    public List<TemplateResponse> getByBotId(Long botId) {
        List<TemplateResponse> listTemplates = templateRepository.findByBotId(botId)
                .stream()
                .map(TemplateMapper::toDTO)
                .toList();

        for (TemplateResponse template : listTemplates){
            if (template.getType().equals("flex")){
               java.util.List<TmpButtonDTO> tmpButtonDTOList = this.getTmpButtonByTemplateId(template.getId());
               template.setTmpButtonDTOList(tmpButtonDTOList);
            }
        }
        return listTemplates;

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

    @Override
    public List<TmpButtonDTO> getTmpButtonByTemplateId(Long templateId){
        return tmpButtonRepository.findByTemplateId(templateId).stream().map(tmpButtonMapper::toDTO).toList();
    }

}
