package model.dao.culture;


import model.Entity.culture;
import model.dao.user.UserDaoHibernateImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CultureHibernateImpl implements CultureDAO {

    private EntityManager entityManager;
    private UserDaoHibernateImpl userDaoHibernate;

    @Autowired
    public CultureHibernateImpl(EntityManager theEntetyManagment, UserDaoHibernateImpl theuserDaoHibernate){
        entityManager =theEntetyManagment;
        userDaoHibernate = theuserDaoHibernate;
    }

    @Override
    public List<culture> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //create a query
        Query<culture> theQuery =
                currentSession.createQuery( "from culture", culture.class );

        List<culture> culture = theQuery.getResultList();
        return culture;
    }

    @Override
    public void save(culture culture) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );
        culture.setUser( userDaoHibernate.findOne(culture.getUserId()));

        //save a user
        currentSession.saveOrUpdate(culture);
    }

    @Override
    public culture findOne(Long id) {
        Session currentSession = entityManager.unwrap( Session.class );

        // now retrieve/read from database using the primary key
        culture culture = currentSession.get(culture.class, id);

        return culture;
    }




}
