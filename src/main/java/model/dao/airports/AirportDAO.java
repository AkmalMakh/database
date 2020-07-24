package model.dao.airports;


import model.Entity.Airports;


import java.util.List;

public interface AirportDAO {
    public List<Airports> findAll();

    //add a country
    public void save(Airports Airports);

    // find one country by id
    Airports findOne(Long id);


}
