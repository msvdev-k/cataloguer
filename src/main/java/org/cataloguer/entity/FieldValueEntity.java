package org.cataloguer.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "field_values")
@Data
public class FieldValueEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private FieldTemplateEntity template;

    @Column(name = "str")
    private String aString;

    @Column(name = "int")
    private Integer aInteger;

    @Column(name = "long")
    private Long aLong;

    @Column(name = "bool")
    private Boolean aBoolean;

    @Column(name = "double")
    private Double aDouble;
}
