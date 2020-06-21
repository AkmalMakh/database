package model.dao.user;

import model.Entity.Countries;
import model.Entity.User;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDaoHibernateImpl implements UserDAO {
    //define field for entitymanager
    private EntityManager entityManager;

    //set up constructor injection
    @Autowired
    public UserDaoHibernateImpl (EntityManager theEntetyManagment){
        entityManager =theEntetyManagment;
    }

    @Override
    public List<User> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //create a query
        Query<User> theQuery =
                currentSession.createQuery( "from User order by lastName", User.class );

        List<User> user = theQuery.getResultList();
        return user;
    }

    @Override
    public void save(User theuser) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap( Session.class );


        //save a user
        currentSession.saveOrUpdate(theuser);
    }

    @Override
    public User findOne(Long id) {
        Session currentSession = entityManager.unwrap( Session.class );

        // now retrieve/read from database using the primary key
        User theUser = currentSession.get(User.class, id);

        return theUser;
    }
}
