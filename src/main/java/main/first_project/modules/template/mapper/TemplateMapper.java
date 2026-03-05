package main.first_project.modules.template.mapper;

import main.first_project.modules.template.dto.TemplateRequest;
import main.first_project.modules.template.dto.TemplateResponse;
import main.first_project.modules.template.entity.Template;

public class TemplateMapper {
    public static Template toEntity(TemplateRequest request){
        Template tmp = new Template();
        tmp.setAdminId(request.getAdminId());
        tmp.setViewName(request.getViewName());
        tmp.setUrlAddFriend(request.getUrlAddFriend());
        tmp.setPlanType(request.getPlanType());
        tmp.setExpiredDate(request.getExpiredDate());
        tmp.setBillStatus(request.getBillStatus());
        return tmp;
    }

    public static TemplateResponse toDTO(Template tmp){
        TemplateResponse res = new TemplateResponse();
        res.setId(tmp.getId());
        res.setAdminId(tmp.getAdminId());
        res.setViewName(tmp.getViewName());
        res.setUrlAddFriend(tmp.getUrlAddFriend());
        res.setPlanType(tmp.getPlanType());
        res.setExpiredDate(tmp.getExpiredDate());
        res.setBillStatus(tmp.getBillStatus());
        return res;
    }
}
