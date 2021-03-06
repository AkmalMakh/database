package model.restController;


import model.Entity.Countries;

import model.service.Country.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/country")
public class CountriesController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CountryService countryService;

    @RequestMapping("/all")
    public List<Countries> findAll(){
        return countryService.findAll();
    }


    @RequestMapping("/add")
    public Countries addUser(@RequestBody Countries countries) {


        return countryService.save( countries );
    }
    @RequestMapping("/{id}")
    public Countries findOne(@PathVariable Long id){
        return countryService.findOne(id);
    }




}
