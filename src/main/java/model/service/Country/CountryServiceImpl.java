package model.service.Country;

import model.Entity.Countries;

import model.dao.countires.CountryHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    private CountryHibernateImpl countryHibernate;

    @Autowired
    public CountryServiceImpl(CountryHibernateImpl thecountryHibernate){
        countryHibernate = thecountryHibernate;
    }

    @Override
    @Transactional
    public List<Countries> findAll() {
        return countryHibernate.findAll();
    }

    @Override
    @Transactional
    public Countries save(Countries countries) {
        countryHibernate.save( countries );
        return countries;
    }

    @Override
    public Countries findOne(Long id) {
        return countryHibernate.findOne( id );
    }


}
