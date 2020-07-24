package model.dao.restaurants;


import model.Entity.Hotels;
import model.Entity.Restaurants;

import java.util.List;

public interface restaurantsDAO {
    public List<Restaurants> findAll();

    //add a country
    public void save(Restaurants theRestaurants);

    // find one country by id
    Restaurants findOne(Long id);


}
