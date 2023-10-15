package com.shittu24.ecommerce.dao;

import com.shittu24.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries")
//http://localhost:8000/api/countries
public interface CountryRepository extends JpaRepository<Country, Integer> {
}
