package model.service.restaurants;


import model.Entity.Hotels;
import model.Entity.Restaurants;
import model.dao.hotels.HotelsHibernateImpl;
import model.dao.restaurants.RestaurantsHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RestaurantsServiceImpl implements RestaurantsService {

    private RestaurantsHibernateImpl restaurantsHibernate;

    @Autowired
    public RestaurantsServiceImpl(RestaurantsHibernateImpl theRestaurantsHibernateImpl){
        restaurantsHibernate = theRestaurantsHibernateImpl;
    }

    @Override
    @Transactional
    public List< Restaurants> findAll() {
        return restaurantsHibernate.findAll();
    }

    @Override
    @Transactional
    public Restaurants save(Restaurants  Restaurants) {
        restaurantsHibernate.save(  Restaurants );
        return  Restaurants;
    }

    @Override
    public  Restaurants findOne(Long id) {
        return restaurantsHibernate.findOne( id );
    }


}
