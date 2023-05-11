package org.cataloguer.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.cataloguer.entity.converter.*;

import java.util.List;

@Entity
@Table(name = "field_templates")
@Data
public class FieldTemplateEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    @Convert(converter = FieldTypeConverter.class)
    private FieldType type;

    @Column(name = "format")
    @Convert(converter = FieldFormatConverter.class)
    private FieldFormat format;

    @OneToMany(mappedBy = "template")
    private List<FieldValueEntity> values;
}
