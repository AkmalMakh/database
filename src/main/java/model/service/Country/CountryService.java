
package model.service.Country;

import model.Entity.Countries;


import java.util.List;

public interface CountryService {
    public List<Countries> findAll();
    public Countries save(Countries countries);
    public Countries findOne(Long id);




}

