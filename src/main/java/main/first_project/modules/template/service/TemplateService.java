package main.first_project.modules.template.service;

import main.first_project.modules.template.dto.TemplateRequest;
import main.first_project.modules.template.dto.TemplateResponse;
import main.first_project.modules.template.dto.TmpButtonDTO;
import main.first_project.modules.template.entity.TmpButton;

import java.util.List;


public interface TemplateService {

    List<TemplateResponse> getAll();
    List<TemplateResponse> getByBotId(Long botId);
    List<TmpButtonDTO> getTmpButtonByTemplateId(Long templateId);

    TemplateResponse create(TemplateRequest request);
    TemplateResponse getById(Long id);
}
