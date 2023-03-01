package se.iths.enterprise.lab1.country;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/countries")
public class CountryResource {

    @Inject
    CountryRepository repository;

    @GET
    @Path("/country/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Country getCountry(@PathParam("id") Long id) {
        return repository.getCountry(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCountry(Country country) {
        repository.addCountry(country);
    }

    @PUT
    @Path("/update/{id}-{change}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCountry(@PathParam("id") Long id, @PathParam("change") String change) {
        repository.updateCountry(id, change);
    }

    @DELETE
    @Path("/remove/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void removeCountry(@PathParam("id") Long id) {
        repository.removeCountry(id);
    }
}
