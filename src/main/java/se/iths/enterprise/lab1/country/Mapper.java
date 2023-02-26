package se.iths.enterprise.lab1.country;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
@ApplicationScoped
public class Mapper {

    public List<CountryDto> map(List<Country> all) {
        return all.stream().map(country-> new CountryDto(country.getId(), country.getName())).toList();
    }
}
