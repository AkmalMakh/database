
package model.service.cities;

import model.Entity.Countries;
import model.Entity.cities;

import java.util.List;

public interface citiesService {
    public List<cities> findAll();
    public cities save(cities cities);
    public cities findOne(Long id);




}

