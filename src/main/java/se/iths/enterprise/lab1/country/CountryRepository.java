package se.iths.enterprise.lab1.country;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Transactional
public class CountryRepository {
    @PersistenceContext
    EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Country> findAll(){
        var query = entityManager.createQuery("SELECT c FROM Country c");
        return (List<Country>) query.getResultList();
    }

    public Optional<Country> findOne(Long id){
        return Optional.ofNullable(entityManager.find(Country.class, id));
    }

    public Country getCountry(Long id){
        return entityManager.find(Country.class, id);
    }

    public void addCountry(Country country){
        entityManager.persist(country);
    }

    public void updateCountry(Long id, String change){
        Country country = entityManager.find(Country.class, id);
        if (change.length() == 2)
            country.setShortening(change);
        else
            country.setName(change);
    }

    public void removeCountry(Long id) {
        Country country = entityManager.find(Country.class, id);
        entityManager.remove(country);
    }
}
