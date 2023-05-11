package org.cataloguer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "catalogs")
@Data
public class CatalogEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private UserEntity admin;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "name_lower", insertable = false, updatable = false)
    private String lowerName;

    @Column(name = "description")
    private String description;

    @Column(name = "created", insertable = false, updatable = false)
    private LocalDateTime created;

    @ManyToMany
    @JoinTable(
            name = "catalog_field_templates",
            joinColumns = @JoinColumn(name = "catalog_id"),
            inverseJoinColumns = @JoinColumn(name = "field_template_id"))
    private List<FieldTemplateEntity> fieldTemplates;

    @ManyToMany
    @JoinTable(
            name = "catalog_cards",
            joinColumns = @JoinColumn(name = "catalog_id"),
            inverseJoinColumns = @JoinColumn(name = "card_id"))
    private List<CardEntity> cards;
}
