package model.dao.attractions;


import model.Entity.Attraction;
import model.Entity.culture;

import java.util.List;

public interface AttractionDAO {
    public List<Attraction> findAll();

    //add a country
    public void save(Attraction theAttraction);

    // find one country by id
    Attraction findOne(Long id);


}
