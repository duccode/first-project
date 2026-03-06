package main.first_project.modules.template.mapper;

import main.first_project.modules.template.dto.TemplateRequest;
import main.first_project.modules.template.dto.TemplateResponse;
import main.first_project.modules.template.entity.Template;

public class TemplateMapper {
    public static Template toEntity(TemplateRequest request){
        Template tmp = new Template();
        tmp.setBotId(request.getBotId());
        tmp.setName(request.getName());
        tmp.setCategoryId(request.getCategoryId());
        tmp.setType(request.getType());
        tmp.setContent(request.getContent());
        tmp.setInPark(request.getInPark());

        return tmp;
    }

    public static TemplateResponse toDTO(Template tmp){
        TemplateResponse res = new TemplateResponse();
        res.setId(tmp.getId());
        res.setBotId(tmp.getBotId());
        res.setName(tmp.getName());
        res.setCategoryId(tmp.getCategoryId());
        res.setType(tmp.getType());
        res.setContent(tmp.getContent());
        res.setInPark(tmp.getInPark());
        return res;
    }
}
