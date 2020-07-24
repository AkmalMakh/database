package model.dao.hotels;


import model.Entity.Hotels;
import model.dao.user.UserDaoHibernateImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HotelsHibernateImpl implements hotelsDAO {

    private EntityManager entityManager;
    private UserDaoHibernateImpl userDaoHibernate;

    @Autowired
    public HotelsHibernateImpl(EntityManager theEntetyManagment, UserDaoHibernateImpl theuserDaoHibernate){
        entityManager =theEntetyManagment;
        userDaoHibernate = theuserDaoHibernate;
    }

    @Override
    public List<Hotels> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //create a query
        Query<Hotels> theQuery =
                currentSession.createQuery( "from Hotels", Hotels.class );

        List<Hotels> Hotels = theQuery.getResultList();
        return Hotels;
    }

    @Override
    public void save(Hotels theHotels) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );
        theHotels.setUser( userDaoHibernate.findOne(theHotels.getUserId()));

        //save a user
        currentSession.saveOrUpdate(theHotels);
    }

    @Override
    public Hotels findOne(Long id) {
        Session currentSession = entityManager.unwrap( Session.class );

        // now retrieve/read from database using the primary key
        Hotels Hotels = currentSession.get(Hotels.class, id);

        return Hotels;
    }




}
