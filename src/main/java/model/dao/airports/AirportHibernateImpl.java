package model.dao.airports;


import model.Entity.Airports;
import model.dao.user.UserDaoHibernateImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AirportHibernateImpl implements AirportDAO {

    private EntityManager entityManager;
    private UserDaoHibernateImpl userDaoHibernate;

    @Autowired
    public AirportHibernateImpl(EntityManager theEntetyManagment, UserDaoHibernateImpl theuserDaoHibernate){
        entityManager =theEntetyManagment;
        userDaoHibernate = theuserDaoHibernate;
    }

    @Override
    public List<Airports> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //create a query
        Query<Airports> theQuery =
                currentSession.createQuery( "from Airports", Airports.class );

        List<Airports> Airports = theQuery.getResultList();
        return Airports;
    }

    @Override
    public void save(Airports Airports) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );
        Airports.setUser( userDaoHibernate.findOne(Airports.getUserId()));

        //save a user
        currentSession.saveOrUpdate(Airports);
    }

    @Override
    public Airports findOne(Long id) {
        Session currentSession = entityManager.unwrap( Session.class );

        // now retrieve/read from database using the primary key
        Airports Airports = currentSession.get(Airports.class, id);

        return Airports;
    }




}
