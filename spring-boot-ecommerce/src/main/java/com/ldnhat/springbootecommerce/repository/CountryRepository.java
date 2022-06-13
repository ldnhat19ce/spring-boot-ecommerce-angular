package com.ldnhat.springbootecommerce.repository;

import com.ldnhat.springbootecommerce.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "countryEntities", path = "country")
public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
}
