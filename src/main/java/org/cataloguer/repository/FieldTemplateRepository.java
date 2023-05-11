package org.cataloguer.repository;

import org.cataloguer.entity.FieldTemplateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldTemplateRepository extends CrudRepository<FieldTemplateEntity, Long> {
}
