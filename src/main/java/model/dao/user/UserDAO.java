package model.dao.user;



import model.Entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> findAll();

    public void save(User theuser);

    User findOne(Long id);
    //find all countries that specific user visited

}