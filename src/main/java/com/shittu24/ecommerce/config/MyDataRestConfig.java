package com.shittu24.ecommerce.config;

import com.shittu24.ecommerce.entity.Country;
import com.shittu24.ecommerce.entity.Product;
import com.shittu24.ecommerce.entity.ProductCategory;
import com.shittu24.ecommerce.entity.State;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Value("${spring.data.rest.base-path}")
    private String basePath;
    @Value("${allowed.origins}")
    private String[] theAllowedOrigins;

    private EntityManager entityManager;

    public MyDataRestConfig(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        //RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

        HttpMethod[] theUnsupportedActions = {
                HttpMethod.POST,
                HttpMethod.DELETE,
                HttpMethod.PUT,
                HttpMethod.PATCH
        };

        // disable the listed HTTP methods in the array above for Product, ProductCategory, Country and State classes
        disableHpptMethods(Product.class, config, theUnsupportedActions);
        disableHpptMethods(ProductCategory.class, config, theUnsupportedActions);
        disableHpptMethods(Country.class, config, theUnsupportedActions);
        disableHpptMethods(State.class, config, theUnsupportedActions);

        // call an internal helper method
        exposeIds(config);

        // configure cors mapping
        cors.addMapping(basePath + "/**").allowedOrigins(theAllowedOrigins);

    }

    private static void disableHpptMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config) {

        // expose entity ids

        // Step 1: get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // Step 2: create an array of the entity types
        List<Class> entityClasses = new ArrayList<>();

        // Step 3: get the entity types for the entities
        for (EntityType tempEntityType : entities) {
            entityClasses.add(tempEntityType.getJavaType());
        }

        // Step 4: expose entity ids for the array of entity/domain types
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }

}
