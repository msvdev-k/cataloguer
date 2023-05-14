package org.cataloguer.service;

import lombok.RequiredArgsConstructor;
import org.cataloguer.entity.FieldTemplateEntity;
import org.cataloguer.repository.FieldTemplateRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FieldTemplateService {

    private final FieldTemplateRepository fieldTemplateRepository;

    public FieldTemplateEntity getById(Long id) {
        return fieldTemplateRepository.findById(id).orElseThrow();
    }


    public FieldTemplateEntity newFieldTemplate(FieldTemplateEntity fieldTemplateEntity) {
        fieldTemplateEntity.setId(null);
        return fieldTemplateRepository.save(fieldTemplateEntity);
    }

    public FieldTemplateEntity updateFieldTemplate(FieldTemplateEntity fieldTemplateEntity) {
        FieldTemplateEntity template = getById(fieldTemplateEntity.getId());
        if (fieldTemplateEntity.getName() != null) {
            template.setName(fieldTemplateEntity.getName());
        }
        if (fieldTemplateEntity.getDescription() != null) {
            template.setDescription(fieldTemplateEntity.getDescription());
        }
        return fieldTemplateRepository.save(template);
    }
}
