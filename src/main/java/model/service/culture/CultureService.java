
package model.service.culture;

import model.Entity.Countries;
import model.Entity.culture;

import java.util.List;

public interface CultureService {
    public List<culture> findAll();
    public culture save(culture culture);
    public culture findOne(Long id);




}

