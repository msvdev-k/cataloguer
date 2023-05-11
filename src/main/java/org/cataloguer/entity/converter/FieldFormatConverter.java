package org.cataloguer.entity.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class FieldFormatConverter implements AttributeConverter<FieldFormat, String> {
    @Override
    public String convertToDatabaseColumn(FieldFormat attribute) {
        return null;
    }

    @Override
    public FieldFormat convertToEntityAttribute(String dbData) {
        return null;
    }
}
