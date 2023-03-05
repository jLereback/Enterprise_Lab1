package se.iths.enterprise.lab1.country.dto;

import jakarta.enterprise.context.ApplicationScoped;
import se.iths.enterprise.lab1.country.Country;

import java.util.List;

@ApplicationScoped
public class Mapper {

    public List<CountryDto> map(List<Country> all) {
        return all.stream().map(CountryDto::new).toList();
    }

    public Country map(CountryDto country) {
        var c = new Country();
        c.setId(country.getId());
        c.setName(country.getCountryName());
        c.setShortening(country.getShortening());
        return c;
    }

    public CountryDto map(Country country) {
        return new CountryDto(country);
    }
}
