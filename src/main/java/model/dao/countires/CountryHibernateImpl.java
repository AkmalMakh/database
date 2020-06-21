package model.dao.countires;

import model.Entity.Countries;

import model.dao.user.UserDaoHibernateImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CountryHibernateImpl implements  CountriesDAO {

    private EntityManager entityManager;
    private UserDaoHibernateImpl userDaoHibernate;

    @Autowired
    public CountryHibernateImpl (EntityManager theEntetyManagment,UserDaoHibernateImpl theuserDaoHibernate){
        entityManager =theEntetyManagment;
        userDaoHibernate = theuserDaoHibernate;
    }

    @Override
    public List<Countries> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //create a query
        Query<Countries> theQuery =
                currentSession.createQuery( "from Countries", Countries.class );

        List<Countries> user = theQuery.getResultList();
        return user;
    }

    @Override
    public void save(Countries theCountries) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );
        theCountries.setUser( userDaoHibernate.findOne(theCountries.getUserId()));

        //save a user
        currentSession.saveOrUpdate(theCountries);
    }

    @Override
    public Countries findOne(Long id) {
        Session currentSession = entityManager.unwrap( Session.class );

        // now retrieve/read from database using the primary key
        Countries theCountries = currentSession.get(Countries.class, id);

        return theCountries;
    }




}
