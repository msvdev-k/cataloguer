package org.cataloguer.controller;

import lombok.RequiredArgsConstructor;
import org.cataloguer.entity.CardEntity;
import org.cataloguer.entity.CatalogEntity;
import org.cataloguer.entity.FieldTemplateEntity;
import org.cataloguer.mapper.CardMapper;
import org.cataloguer.mapper.CatalogMapper;
import org.cataloguer.mapper.FieldTemplateMapper;
import org.cataloguer.openapi.api.CatalogApi;
import org.cataloguer.openapi.model.Card;
import org.cataloguer.openapi.model.Catalog;
import org.cataloguer.openapi.model.FieldTemplate;
import org.cataloguer.service.CatalogService;
import org.cataloguer.service.FieldTemplateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class CatalogController implements CatalogApi {

    private final CatalogService catalogService;
    private final FieldTemplateService fieldTemplateService;
    private final CatalogMapper catalogMapper;
    private final CardMapper cardMapper;
    private final FieldTemplateMapper fieldTemplateMapper;

    @Override
    public ResponseEntity<Card> addCard(Long catalogId) {
        CardEntity cardEntity = catalogService.addCard(catalogId);
        Card card = cardMapper.entityToModel(cardEntity);
        return new ResponseEntity<>(card, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Catalog> addCatalog(Catalog catalog) {
        CatalogEntity newCatalog = catalogService.addCatalog(catalog.getName());
        catalog = catalogMapper.entityToModel(newCatalog);
        return new ResponseEntity<>(catalog, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FieldTemplate> addFieldTemplate(Long catalogId, FieldTemplate fieldTemplate) {
        FieldTemplateEntity fieldTemplateEntity = fieldTemplateMapper.modelToEntity(fieldTemplate);
        fieldTemplateEntity = catalogService.addFieldTemplate(catalogId, fieldTemplateEntity);
        fieldTemplate = fieldTemplateMapper.entityToModel(fieldTemplateEntity);
        return new ResponseEntity<>(fieldTemplate, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Card>> cardList(Long catalogId, Integer offset, Integer limit, String sort) {
        List<CardEntity> cardEntities = catalogService.getCards(catalogId);
        List<Card> cards = cardEntities.stream()
                .map(cardMapper::entityToModel)
                .toList();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Catalog>> catalogList(Integer offset, Integer limit, String sort) {
        List<CatalogEntity> catalogEntities = catalogService.findAll();
        List<Catalog> catalogs = catalogEntities.stream()
                .map(catalogMapper::entityToModel)
                .toList();
        return new ResponseEntity<>(catalogs, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<FieldTemplate>> fieldTemplateList(Long catalogId) {
        List<FieldTemplateEntity> fieldTemplateEntities = catalogService.getFieldTemplates(catalogId);
        List<FieldTemplate> fieldTemplates = fieldTemplateEntities.stream()
                .map(fieldTemplateMapper::entityToModel)
                .toList();
        return new ResponseEntity<>(fieldTemplates, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Catalog> getCatalogById(Long catalogId) {
        CatalogEntity catalogEntity = catalogService.getCatalogById(catalogId);
        Catalog catalog = catalogMapper.entityToModel(catalogEntity);
        return new ResponseEntity<>(catalog, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removeCatalogById(Long catalogId) {
        catalogService.removeCatalogById(catalogId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Catalog> updateCatalogById(Long catalogId, Catalog catalog) {
        CatalogEntity catalogEntity = catalogMapper.modelToEntity(catalog);
        catalogEntity.setId(catalogId);
        catalogEntity = catalogService.updateCatalog(catalogEntity);
        catalog = catalogMapper.entityToModel(catalogEntity);
        return new ResponseEntity<>(catalog, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FieldTemplate> updateFieldTemplate(Long catalogId, FieldTemplate fieldTemplate) {
        FieldTemplateEntity fieldTemplateEntity = fieldTemplateMapper.modelToEntity(fieldTemplate);
        fieldTemplateEntity = fieldTemplateService.updateFieldTemplate(fieldTemplateEntity);
        fieldTemplate = fieldTemplateMapper.entityToModel(fieldTemplateEntity);
        return new ResponseEntity<>(fieldTemplate, HttpStatus.CREATED);
    }
}
