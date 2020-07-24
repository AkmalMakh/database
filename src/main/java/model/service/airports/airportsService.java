
package model.service.airports;

import model.Entity.Airports;


import java.util.List;

public interface airportsService {
    public List<Airports> findAll();
    public Airports save(Airports Airports);
    public Airports findOne(Long id);




}

