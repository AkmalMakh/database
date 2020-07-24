package model.service.attractions;


import model.Entity.Attraction;
import model.Entity.culture;
import model.dao.attractions.AttractionHibernateImpl;
import model.dao.culture.CultureHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttractionsServiceImpl implements AttractionsService {

    private AttractionHibernateImpl attractionHibernate;

    @Autowired
    public AttractionsServiceImpl(AttractionHibernateImpl theAttractionHibernate){
        attractionHibernate = theAttractionHibernate;
    }

    @Override
    @Transactional
    public List<Attraction> findAll() {
        return attractionHibernate.findAll();
    }

    @Override
    @Transactional
    public Attraction save(Attraction Attraction) {
        attractionHibernate.save( Attraction );
        return Attraction;
    }

    @Override
    public Attraction findOne(Long id) {
        return attractionHibernate.findOne( id );
    }


}
