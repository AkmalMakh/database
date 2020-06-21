package model.dao.cities;


import model.Entity.cities;

import java.util.List;

public interface CitiesDAO  {
    public List<cities> findAll();

    //add a country
    public void save(cities theCountries);

    // find one country by id
    cities findOne(Long id);


}
