package org.cataloguer.mapper;

import org.cataloguer.entity.CatalogEntity;
import org.cataloguer.openapi.model.Catalog;
import org.springframework.stereotype.Component;

@Component
public class CatalogMapper {

    public Catalog entityToModel(CatalogEntity catalogEntity) {
        Catalog catalog = new Catalog(catalogEntity.getName());
        catalog.setId(catalogEntity.getId());
        return catalog;
    }

    public CatalogEntity modelToEntity(Catalog catalog) {
        CatalogEntity catalogEntity = new CatalogEntity();
        if (catalog.getName() != null) {
            catalogEntity.setName(catalog.getName());
        }
        return catalogEntity;
    }
}
