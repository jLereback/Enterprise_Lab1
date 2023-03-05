package se.iths.enterprise.lab1.country;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Null not allowed for name")
    @Size(min = 4, max = 56)
    private String name;

    @NotNull(message = "Null not allowed for shortening")
    @Size(min = 2, max = 2)
    private String shortening;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortening() {
        return shortening;
    }

    public void setShortening(String shortening) {
        this.shortening = shortening;
    }
}
