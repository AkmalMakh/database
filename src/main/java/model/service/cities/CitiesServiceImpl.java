package model.service.cities;

import model.Entity.cities;
import model.dao.cities.CitiesDAO;

import model.dao.cities.CitiesHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CitiesServiceImpl implements citiesService {

    private CitiesHibernateImpl citiesHibernate;

    @Autowired
    public CitiesServiceImpl(CitiesHibernateImpl thecitiesHibernate){
        citiesHibernate = thecitiesHibernate;
    }

    @Override
    @Transactional
    public List<cities> findAll() {
        return citiesHibernate.findAll();
    }


    @Override
    @Transactional
    public cities save(cities cities) {
        citiesHibernate.save( cities );
        return cities;
    }

    @Override
    public cities findOne(Long id) {
        return citiesHibernate.findOne( id );
    }


}
