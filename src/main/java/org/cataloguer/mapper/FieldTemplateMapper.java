package org.cataloguer.mapper;

import org.cataloguer.entity.FieldTemplateEntity;
import org.cataloguer.entity.converter.FieldType;
import org.cataloguer.openapi.model.FieldTemplate;
import org.springframework.stereotype.Component;

@Component
public class FieldTemplateMapper {
    public FieldTemplate entityToModel(FieldTemplateEntity fieldTemplateEntity) {
        FieldTemplate fieldTemplate = new FieldTemplate();
        fieldTemplate.setId(fieldTemplateEntity.getId());
        fieldTemplate.setName(fieldTemplateEntity.getName());
        fieldTemplate.setDescription(fieldTemplateEntity.getDescription());
        return fieldTemplate;
    }

    public FieldTemplateEntity modelToEntity(FieldTemplate fieldTemplate) {
        FieldTemplateEntity fieldTemplateEntity = new FieldTemplateEntity();
        fieldTemplateEntity.setId(fieldTemplate.getId());
        fieldTemplateEntity.setName(fieldTemplate.getName());
        fieldTemplateEntity.setDescription(fieldTemplate.getDescription());
        fieldTemplateEntity.setType(FieldType.STRING);
        return fieldTemplateEntity;
    }
}
