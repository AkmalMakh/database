package model.dao.countires;


import model.Entity.Countries;


import java.util.List;

public interface CountriesDAO {
    public List<Countries> findAll();

    //add a country
    public void save(Countries theCountries);

    // find one country by id
    Countries findOne(Long id);


}
