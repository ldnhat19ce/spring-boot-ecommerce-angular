package com.ldnhat.springbootecommerce.config;

import com.ldnhat.springbootecommerce.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    @Value("${allowed.origins}")
    private String allowedOrigins;

    @Resource
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE,
        HttpMethod.PATCH
        };
        // disable http methods for productEntity class: put, post, delete
        disableHttpMethods(config, theUnsupportedActions, ProductEntity.class);

        // disable http methods for productCategoryEntity class: put, post, delete
        disableHttpMethods(config, theUnsupportedActions, ProductCategoryEntity.class);
        disableHttpMethods(config, theUnsupportedActions, CityEntity.class);
        disableHttpMethods(config, theUnsupportedActions, CountryEntity.class);
        disableHttpMethods(config, theUnsupportedActions, Orders.class);
        exposeIds(config);
        System.out.println(allowedOrigins);
        cors.addMapping(config.getBasePath()+"/**")
                .allowedOrigins(allowedOrigins);
    }

    private void disableHttpMethods(RepositoryRestConfiguration config,
                                    HttpMethod[] theUnsupportedActions,
                                    Class<?> theClass
                                    ) {
        config.getExposureConfiguration().forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids

        // - get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // - create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // - get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // - expose the entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }
}
