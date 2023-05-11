package org.cataloguer.controller;

import org.cataloguer.openapi.api.CatalogApi;
import org.cataloguer.openapi.model.Card;
import org.cataloguer.openapi.model.Catalog;
import org.cataloguer.openapi.model.FieldTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class CatalogController implements CatalogApi {
    @Override
    public ResponseEntity<Card> addCard(Long catalogId) {
        return CatalogApi.super.addCard(catalogId);
    }

    @Override
    public ResponseEntity<Catalog> addCatalog(Catalog catalog) {
        return CatalogApi.super.addCatalog(catalog);
    }

    @Override
    public ResponseEntity<FieldTemplate> addFieldTemplate(Long catalogId, FieldTemplate fieldTemplate) {
        return CatalogApi.super.addFieldTemplate(catalogId, fieldTemplate);
    }

    @Override
    public ResponseEntity<List<Card>> cardList(Long catalogId, Integer offset, Integer limit, String sort) {
        return CatalogApi.super.cardList(catalogId, offset, limit, sort);
    }

    @Override
    public ResponseEntity<List<Catalog>> catalogList(Integer offset, Integer limit, String sort) {
        return CatalogApi.super.catalogList(offset, limit, sort);
    }

    @Override
    public ResponseEntity<List<FieldTemplate>> fieldTemplateList(Long catalogId) {
        return CatalogApi.super.fieldTemplateList(catalogId);
    }

    @Override
    public ResponseEntity<Catalog> getCatalogById(Long catalogId) {
        return CatalogApi.super.getCatalogById(catalogId);
    }

    @Override
    public ResponseEntity<Void> removeCatalogById(Long catalogId) {
        return CatalogApi.super.removeCatalogById(catalogId);
    }

    @Override
    public ResponseEntity<Catalog> updateCatalogById(Long catalogId, Catalog catalog) {
        return CatalogApi.super.updateCatalogById(catalogId, catalog);
    }

    @Override
    public ResponseEntity<FieldTemplate> updateFieldTemplate(Long catalogId, FieldTemplate fieldTemplate) {
        return CatalogApi.super.updateFieldTemplate(catalogId, fieldTemplate);
    }
}
