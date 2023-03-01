package se.iths.enterprise.lab1.country;

public class CountryDto {
    private Long id;
    private String countryName;

    private String shortening;

    public CountryDto() {
    }

    public CountryDto(Long id, String countryName, String shortening) {
        this.id = id;
        this.countryName = countryName;
        this.shortening = shortening;
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
