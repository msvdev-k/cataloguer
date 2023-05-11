package org.cataloguer.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cards")
@Data
public class CardEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created", insertable = false, updatable = false)
    private LocalDateTime created;

    @ManyToMany
    @JoinTable(
            name = "catalog_cards",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "catalog_id"))
    private List<CatalogEntity> catalogs;

    @ManyToMany
    @JoinTable(
            name = "card_fields",
            joinColumns = @JoinColumn(name = "card_id"),
            inverseJoinColumns = @JoinColumn(name = "value_id"))
    private List<FieldValueEntity> values;
}
