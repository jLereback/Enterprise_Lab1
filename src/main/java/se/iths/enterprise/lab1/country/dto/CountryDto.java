package se.iths.enterprise.lab1.country.dto;

import se.iths.enterprise.lab1.country.Country;

public class CountryDto {
    private Long id;
    private String countryName;

    private String shortening;

    public CountryDto() {
    }

    public CountryDto(Country country) {
        this.id = country.getId();
        this.countryName = country.getName();
        this.shortening = country.getShortening();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getShortening() {
        return shortening;
    }

    public void setShortening(String shortening) {
        this.shortening = shortening;
    }
}
