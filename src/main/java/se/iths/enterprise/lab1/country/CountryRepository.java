package se.iths.enterprise.lab1.country;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
@Transactional
public class CountryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Country> findAll(){
        var query = entityManager.createQuery("select c from Country c");
        return (List<Country>) query.getResultList();
    }

    public List<Country> findAllByName(String name) {
        var query = entityManager.createQuery("select c from Country c where c.name like :name");
        query.setParameter("name", name);
        return (List<Country>) query.getResultList();
    }
}
