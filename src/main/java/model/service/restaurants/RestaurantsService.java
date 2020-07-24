
package model.service.restaurants;

import model.Entity.Hotels;
import model.Entity.Restaurants;

import java.util.List;

public interface RestaurantsService {
    public List< Restaurants> findAll();
    public  Restaurants save( Restaurants Restaurants);
    public  Restaurants findOne(Long id);




}

