package model.service.user;

import model.Entity.User;
import model.dao.user.UserDAO;
import model.dao.user.UserDaoHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService{

    private UserDaoHibernateImpl userDaoHibernate;
    @Autowired
    public UserServiceImpl(UserDaoHibernateImpl theuserDaoHibernate){
        userDaoHibernate = theuserDaoHibernate;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDaoHibernate.findAll();
    }

    @Override
    @Transactional
    public void save(User theUser) {
        userDaoHibernate.save( theUser );
    }

    @Override
    public User findOne(Long id) {
        return userDaoHibernate.findOne( id );
    }
}
