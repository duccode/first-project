package main.first_project.modules.template.service;

import main.first_project.modules.template.dto.TemplateDTO;
import main.first_project.modules.template.dto.TmpButtonDTO;

import java.util.List;


public interface TemplateService {

    List<TemplateDTO> getAll();
    List<TemplateDTO> getByBotId(Long botId);
    List<TmpButtonDTO> getTmpButtonByTemplateId(Long templateId);

    TemplateDTO create(TemplateDTO request);
    TemplateDTO getById(Long id);
}
