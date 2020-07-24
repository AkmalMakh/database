package model.restController;


import model.Entity.Airports;
import model.Entity.culture;
import model.service.culture.CultureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/culture")
public class CultureController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private CultureService cultureService;

    @RequestMapping("/all")
    public List<culture> findAll(){
        return cultureService.findAll();
    }


    @RequestMapping("/add")
    public culture addUser(@RequestBody culture culture) {


        return cultureService.save( culture );
    }
    @RequestMapping("/{id}")
    public culture findOne(@PathVariable Long id){
        return cultureService.findOne(id);
    }


}
