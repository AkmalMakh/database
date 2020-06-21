package model.restController;


import model.Entity.cities;
import model.service.cities.citiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/cities")
public class CitiesController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private citiesService citiesService;

    @RequestMapping("/all")
    public List<cities> findAll(){
        return citiesService.findAll();
    }


    @RequestMapping("/add")
    public cities addUser(@RequestBody cities cities) {


        return citiesService.save( cities );
    }
    @RequestMapping("/{id}")
    public cities findOne(@PathVariable Long id){
        return citiesService.findOne(id);
    }




}