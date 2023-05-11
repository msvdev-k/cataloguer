package org.cataloguer.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class FieldTypeConverter implements AttributeConverter<FieldType, String> {
    @Override
    public String convertToDatabaseColumn(FieldType attribute) {
        return (attribute != null) ? attribute.getCode() : null;
    }

    @Override
    public FieldType convertToEntityAttribute(String dbData) {
        return (dbData != null) ? FieldType.fromCode(dbData) : null;
    }
}
