package model.dao.cities;

import model.Entity.cities;

import model.dao.user.UserDaoHibernateImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CitiesHibernateImpl implements CitiesDAO {

    private EntityManager entityManager;
    private UserDaoHibernateImpl userDaoHibernate;

    @Autowired
    public CitiesHibernateImpl(EntityManager theEntetyManagment, UserDaoHibernateImpl theuserDaoHibernate){
        entityManager =theEntetyManagment;
        userDaoHibernate = theuserDaoHibernate;
    }

    @Override
    public List<cities> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //create a query
        Query<cities> theQuery =
                currentSession.createQuery( "from cities", cities.class );

        List<cities> user = theQuery.getResultList();
        return user;
    }

    @Override
    public void save(cities thecities) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );
        thecities.setUser( userDaoHibernate.findOne(thecities.getUserId()));

        //save a user
        currentSession.saveOrUpdate(thecities);

    }

    @Override
    public cities findOne(Long id) {
        Session currentSession = entityManager.unwrap( Session.class );

        // now retrieve/read from database using the primary key
        cities thecities = currentSession.get(cities.class, id);

        return thecities;
    }




}
