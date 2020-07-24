package model.restController;



import model.Entity.Airports;
import model.service.airports.airportsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/airports")
public class AirportController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private airportsService airportsService;

    @RequestMapping("/all")
    public List<Airports> findAll(){
        return airportsService.findAll();
    }


    @RequestMapping("/add")
    public Airports addUser(@RequestBody Airports airports) {


        return airportsService.save( airports );
    }
    @RequestMapping("/{id}")
    public Airports findOne(@PathVariable Long id){
        return airportsService.findOne(id);
    }


}
