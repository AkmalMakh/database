package model.service.culture;


import model.Entity.culture;
import model.dao.culture.CultureHibernateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CultureServiceImpl implements CultureService {

    private CultureHibernateImpl CultureHibernate;

    @Autowired
    public CultureServiceImpl(CultureHibernateImpl theCultureHibernate){
        CultureHibernate = theCultureHibernate;
    }

    @Override
    @Transactional
    public List<culture> findAll() {
        return CultureHibernate.findAll();
    }

    @Override
    @Transactional
    public culture save(culture culture) {
        CultureHibernate.save( culture );
        return culture;
    }

    @Override
    public culture findOne(Long id) {
        return CultureHibernate.findOne( id );
    }


}
