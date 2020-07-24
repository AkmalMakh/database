package model.restController;

import model.Entity.Restaurants;
import model.service.restaurants.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/restaurants")
public class RestaurantsController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private RestaurantsService restaurantsService;

    @RequestMapping("/all")
    public List<Restaurants> findAll(){
        return restaurantsService.findAll();
    }


    @RequestMapping("/add")
    public Restaurants addUser(@RequestBody Restaurants Restaurants) {


        return restaurantsService.save( Restaurants );
    }
    @RequestMapping("/{id}")
    public Restaurants findOne(@PathVariable Long id){
        return restaurantsService.findOne(id);
    }

}