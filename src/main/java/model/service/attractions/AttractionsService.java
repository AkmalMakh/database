
package model.service.attractions;

import model.Entity.Attraction;
import model.Entity.culture;

import java.util.List;

public interface AttractionsService {
    public List<Attraction> findAll();
    public Attraction save(Attraction Attraction);
    public Attraction findOne(Long id);




}

