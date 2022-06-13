package com.ldnhat.springbootecommerce.repository;

import com.ldnhat.springbootecommerce.entity.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
// collectionResourceRel: name of json entry
public interface ProductCategoryRepository extends JpaRepository<ProductCategoryEntity, Long> {
}
