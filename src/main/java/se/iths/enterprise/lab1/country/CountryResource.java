package se.iths.enterprise.lab1.country;

import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import se.iths.enterprise.lab1.country.dto.CountryDto;
import se.iths.enterprise.lab1.country.dto.Mapper;
import se.iths.enterprise.lab1.exceptions.IdNotFoundException;

import java.net.URI;
import java.util.List;

@Path("/countries")
public class CountryResource {

    @Inject
    CountryRepository repository;

    @Inject
    Mapper mapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> getAllCountries() {
        return mapper.map(repository.findAll());
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public CountryDto getCountry(@PathParam("id") Long id) {
        if (repository.findOne(id).isEmpty())
            throw new IdNotFoundException("Id_not_found: " + id);
        return mapper.map(repository.getCountry(id));
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCountry(@Valid Country country) {
        repository.addCountry(country);
        return Response.created(URI.create("countries/" + country.getId())).build();
    }

    @PUT
    @Path("/{id}-{change}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCountry(@PathParam("id") Long id, @PathParam("change") String change) {
        var country = repository.findOne(id);
        if (country.isEmpty())
            throw new IdNotFoundException("Id_not_found: " + id);
        repository.updateCountry(id, change);
        return Response.ok(repository.findOne(id)).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeCountry(@PathParam("id") Long id) {
        repository.removeCountry(id);
        return Response.ok().build();
    }
}
