package model.dao.attractions;


import model.Entity.Attraction;
import model.dao.user.UserDaoHibernateImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class AttractionHibernateImpl implements AttractionDAO {

    private EntityManager entityManager;
    private UserDaoHibernateImpl userDaoHibernate;

    @Autowired
    public AttractionHibernateImpl(EntityManager theEntetyManagment, UserDaoHibernateImpl theuserDaoHibernate){
        entityManager =theEntetyManagment;
        userDaoHibernate = theuserDaoHibernate;
    }

    @Override
    public List<Attraction> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //create a query
        Query<Attraction> theQuery =
                currentSession.createQuery( "from Attraction", Attraction.class );

        List<Attraction> Attraction = theQuery.getResultList();
        return Attraction;
    }

    @Override
    public void save(Attraction Attraction) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );
        Attraction.setUser( userDaoHibernate.findOne(Attraction.getUserId()));

        //save a user
        currentSession.saveOrUpdate(Attraction);
    }

    @Override
    public Attraction findOne(Long id) {
        Session currentSession = entityManager.unwrap( Session.class );

        // now retrieve/read from database using the primary key
        Attraction Attraction = currentSession.get(Attraction.class, id);

        return Attraction;
    }




}
