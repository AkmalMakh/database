package model.service.user;


import model.Entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();
    public  void save(User theUser);
    public User findOne(Long id);
}
