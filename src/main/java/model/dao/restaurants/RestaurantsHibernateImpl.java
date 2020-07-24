package model.dao.restaurants;

import model.Entity.Restaurants;
import model.dao.user.UserDaoHibernateImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RestaurantsHibernateImpl implements restaurantsDAO {

    private EntityManager entityManager;
    private UserDaoHibernateImpl userDaoHibernate;

    @Autowired
    public RestaurantsHibernateImpl(EntityManager theEntetyManagment, UserDaoHibernateImpl theuserDaoHibernate){
        entityManager =theEntetyManagment;
        userDaoHibernate = theuserDaoHibernate;
    }

    @Override
    public List<Restaurants> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //create a query
        Query<Restaurants> theQuery =
                currentSession.createQuery( "from Restaurants", Restaurants.class );

        List<Restaurants> Restaurants = theQuery.getResultList();
        return Restaurants;
    }

    @Override
    public void save(Restaurants Restaurants) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );
        Restaurants.setUser( userDaoHibernate.findOne(Restaurants.getUserId()));

        //save a user
        currentSession.saveOrUpdate(Restaurants);
    }

    @Override
    public Restaurants findOne(Long id) {
        Session currentSession = entityManager.unwrap( Session.class );

        // now retrieve/read from database using the primary key
        Restaurants Restaurants = currentSession.get(Restaurants.class, id);

        return Restaurants;
    }




}
