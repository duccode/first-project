package main.first_project.modules.template.service;


import main.first_project.exception.NotFoundException;
import main.first_project.modules.template.dto.ButtonDTO;
import main.first_project.modules.template.dto.TemplateDTO;
import main.first_project.modules.template.dto.TmpButtonDTO;
import main.first_project.modules.template.entity.Button;
import main.first_project.modules.template.entity.Template;
import main.first_project.modules.template.mapper.ButtonMapper;
import main.first_project.modules.template.mapper.TemplateMapper;
import main.first_project.modules.template.mapper.TmpButtonMapper;
import main.first_project.modules.template.repository.ButtonRepository;
import main.first_project.modules.template.repository.TemplateRepository;
import main.first_project.modules.template.repository.TmpButtonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;
    private final TmpButtonRepository tmpButtonRepository;
    private final ButtonRepository buttonRepository;
    @Autowired
    private TmpButtonMapper tmpButtonMapper;
    @Autowired
    private TemplateMapper templateMapper;
    @Autowired
    private ButtonMapper buttonMapper;

    public TemplateServiceImpl(
            TemplateRepository templateRepository,
            TmpButtonRepository tmpButtonRepository,
            ButtonRepository buttonRepository)
    {
        this.templateRepository = templateRepository;
        this.tmpButtonRepository = tmpButtonRepository;
        this.buttonRepository = buttonRepository;
    }

    @Override
    public List<TemplateDTO> getAll(){
        return templateRepository.findAll()
                .stream()
                .map(templateMapper::toDTO)
                .toList();
    }

    @Override
    public List<TemplateDTO> getByBotId(Long botId) {
        List<Template> templates = templateRepository.findByBotId(botId);
        List<TemplateDTO> listTemplates = templateMapper.toDTOList(templates);

        for (TemplateDTO template : listTemplates){
            if (template.getType().equals("flex") || template.getType().equals("form")){
               List<TmpButtonDTO> tmpButtonDTOList = this.getTmpButtonByTemplateId(template.getId());
               for (TmpButtonDTO tmpButton : tmpButtonDTOList){
                   List<Button> buttons = buttonRepository.getListButtonByButtonId(tmpButton.getId());
                   List<ButtonDTO> listButtons = buttonMapper.toDTOList(buttons);
                   tmpButton.setListButtonDTO(listButtons);
               }
               template.setTmpButtonDTOList(tmpButtonDTOList);
            }
        }
        return listTemplates;

    }

    @Override
    public TemplateDTO create(TemplateDTO request){

        Template template = templateMapper.toEntity(request);

        Template saved = templateRepository.save(template);

        return templateMapper.toDTO(saved);
    }

    @Override
    public TemplateDTO getById(Long id){

        Template template = templateRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Template not found"));

        TemplateDTO templateDTO = templateMapper.toDTO(template);

        if (templateDTO.getType().equals("flex") || templateDTO.getType().equals("form")){
            List<TmpButtonDTO> tmpButtonDTOList = this.getTmpButtonByTemplateId(template.getId());
            for (TmpButtonDTO tmpButton : tmpButtonDTOList){
                List<Button> buttons = buttonRepository.getListButtonByButtonId(tmpButton.getId());
                List<ButtonDTO> listButtons = buttonMapper.toDTOList(buttons);
                tmpButton.setListButtonDTO(listButtons);
            }
            templateDTO.setTmpButtonDTOList(tmpButtonDTOList);
        }
        return templateDTO;
    }

    @Override
    public List<TmpButtonDTO> getTmpButtonByTemplateId(Long templateId){
        return tmpButtonRepository.findByTemplateId(templateId).stream().map(tmpButtonMapper::toDTO).toList();
    }

}
