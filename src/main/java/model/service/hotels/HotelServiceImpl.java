package model.service.hotels;


import model.Entity.Hotels;
import model.Entity.culture;
import model.dao.culture.CultureHibernateImpl;
import model.dao.hotels.HotelsHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelsHibernateImpl HotelsHibernate;

    @Autowired
    public HotelServiceImpl(HotelsHibernateImpl theHotelsHibernateImpl){
        HotelsHibernate = theHotelsHibernateImpl;
    }

    @Override
    @Transactional
    public List<Hotels> findAll() {
        return HotelsHibernate.findAll();
    }

    @Override
    @Transactional
    public Hotels save(Hotels Hotels) {
        HotelsHibernate.save( Hotels );
        return Hotels;
    }

    @Override
    public Hotels findOne(Long id) {
        return HotelsHibernate.findOne( id );
    }


}
