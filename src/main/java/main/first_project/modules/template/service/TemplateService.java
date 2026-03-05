package main.first_project.modules.template.service;

import main.first_project.modules.template.dto.TemplateRequest;
import main.first_project.modules.template.dto.TemplateResponse;

import java.util.List;


public interface TemplateService {

    List<TemplateResponse> getAll();
    List<TemplateResponse> getByAdminId(Long adminId);

    TemplateResponse create(TemplateRequest request);
    TemplateResponse getById(Long id);
}
