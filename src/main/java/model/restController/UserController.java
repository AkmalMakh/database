package model.restController;


import java.util.List;

import model.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import model.Entity.User;


@RestController // This means that this class is a Controller
@RequestMapping(path="/user")
public class UserController {
    @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private UserService userService;

  @GetMapping("/all")
  public List<User> findAll(){
      return userService.findAll();
  }


  @PostMapping("/add")
    public User addUser(@RequestBody User theUser){

    userService.save( theUser );
    return theUser;
  }
  @RequestMapping("/{id}")
  public User findOne(@PathVariable Long id){
    return userService.findOne(id);
  }
}