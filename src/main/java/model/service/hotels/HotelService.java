
package model.service.hotels;

import model.Entity.Hotels;
import model.Entity.culture;

import java.util.List;

public interface HotelService {
    public List<Hotels> findAll();
    public Hotels save(Hotels Hotels);
    public Hotels findOne(Long id);




}

