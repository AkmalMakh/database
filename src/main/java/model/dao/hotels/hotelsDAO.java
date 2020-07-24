package model.dao.hotels;


import model.Entity.Hotels;
import model.Entity.culture;

import java.util.List;

public interface hotelsDAO {
    public List<Hotels> findAll();

    //add a country
    public void save(Hotels theHotels);

    // find one country by id
    Hotels findOne(Long id);


}
