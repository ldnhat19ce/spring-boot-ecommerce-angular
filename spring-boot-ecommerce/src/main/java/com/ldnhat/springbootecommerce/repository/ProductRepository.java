package com.ldnhat.springbootecommerce.repository;

import com.ldnhat.springbootecommerce.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Page<ProductEntity> findByProductCategoryEntityId(@RequestParam("id") Long id, Pageable pageable);
    // containing: 'like'
    Page<ProductEntity> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
