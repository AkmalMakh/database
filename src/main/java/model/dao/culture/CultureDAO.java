package model.dao.culture;


import model.Entity.culture;

import java.util.List;

public interface CultureDAO {
    public List<culture> findAll();

    //add a country
    public void save(culture theculture);

    // find one country by id
    culture findOne(Long id);


}
