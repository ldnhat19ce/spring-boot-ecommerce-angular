package com.ldnhat.springbootecommerce.repository;

import com.ldnhat.springbootecommerce.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cityEntities", path = "city")
public interface CityRepository extends JpaRepository<CityEntity, Integer> {

    List<CityEntity> findByCountryEntityCode(@Param("code") String code);
}
