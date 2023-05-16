package org.cataloguer.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.cataloguer.entity.CardEntity;
import org.cataloguer.entity.CatalogEntity;
import org.cataloguer.entity.FieldTemplateEntity;
import org.cataloguer.repository.CatalogRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogRepository catalogRepository;
    private final FieldTemplateService fieldTemplateService;
    private final CardService cardService;
    private final UserService userService;


    public CatalogEntity addCatalog(String name) {
        CatalogEntity catalog = new CatalogEntity();
        catalog.setName(name);
        catalog.setAdmin(userService.getCurrentUser());
        return catalogRepository.save(catalog);
    }


    public CatalogEntity getCatalogById(Long catalogId) {
        return catalogRepository.findById(catalogId).orElseThrow();
    }


    public List<CatalogEntity> findAll() {
        List<CatalogEntity> catalogEntities = new ArrayList<>();
        catalogRepository.findAll().forEach(catalogEntities::add);
        return catalogEntities;
    }


    public void removeCatalogById(Long catalogId) {
        catalogRepository.deleteById(catalogId);
    }


    public CatalogEntity updateCatalog(CatalogEntity catalogEntity) {
        CatalogEntity catalogToUpdate = getCatalogById(catalogEntity.getId());
        if (catalogEntity.getName() != null) {
            catalogToUpdate.setName(catalogEntity.getName());
        }
        return catalogRepository.save(catalogToUpdate);
    }


    public List<FieldTemplateEntity> getFieldTemplates(Long catalogId) {
        CatalogEntity catalog = getCatalogById(catalogId);
        return catalog.getFieldTemplates();
    }

    @Transactional
    public FieldTemplateEntity addFieldTemplate(Long catalogId, FieldTemplateEntity fieldTemplateEntity) {
        CatalogEntity catalog = getCatalogById(catalogId);
        fieldTemplateEntity = fieldTemplateService.newFieldTemplate(fieldTemplateEntity);
        catalog.getFieldTemplates().add(fieldTemplateEntity);
        catalogRepository.save(catalog);
        return fieldTemplateEntity;
    }

    @Transactional
    public CardEntity addCard(Long catalogId) {
        CatalogEntity catalog = getCatalogById(catalogId);
        CardEntity card = cardService.newCard();
        catalog.getCards().add(card);
        catalogRepository.save(catalog);
        return card;
    }

    public List<CardEntity> getCards(Long catalogId) {
        CatalogEntity catalog = getCatalogById(catalogId);
        return catalog.getCards();
    }
}
