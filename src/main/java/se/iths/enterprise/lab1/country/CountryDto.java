package se.iths.enterprise.lab1.country;

public class CountryDto {
    private Long id;
    private String countryName;

    public CountryDto() {
    }

    public CountryDto(Long id, String dishName) {
        this.id = id;
        this.countryName = dishName;
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
}
