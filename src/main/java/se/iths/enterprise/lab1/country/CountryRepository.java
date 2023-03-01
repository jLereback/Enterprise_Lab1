package se.iths.enterprise.lab1.country;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CountryRepository {
    @PersistenceContext
    EntityManager entityManager;

    public Country getCountry(Long id){
        return (entityManager.find(Country.class, id));
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
