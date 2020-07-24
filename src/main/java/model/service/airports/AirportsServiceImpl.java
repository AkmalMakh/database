package model.service.airports;

import model.Entity.Airports;

import model.dao.airports.AirportHibernateImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AirportsServiceImpl implements airportsService {

    private AirportHibernateImpl AirportsHibernate;

    @Autowired
    public AirportsServiceImpl(AirportHibernateImpl AirportHibernateImpl){
        AirportsHibernate = AirportHibernateImpl;
    }

    @Override
    @Transactional
    public List<Airports> findAll() {
        return AirportsHibernate.findAll();
    }


    @Override
    @Transactional
    public Airports save(Airports Airports) {
        AirportsHibernate.save( Airports );
        return Airports;
    }

    @Override
    public Airports findOne(Long id) {
        return AirportsHibernate.findOne( id );
    }


}
