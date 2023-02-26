package se.iths.enterprise.lab1.country;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/countries")
public class CountryController {

    @Inject
    CountryRepository repository;

    @Inject
    Mapper mapper;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CountryDto> getAll(@QueryParam("name") String name){
        if( name == null)
            return mapper.map(repository.findAll());

        return mapper.map(repository.findAllByName(name));
    }
    @GET
    public Response getAll() {

        return Response.ok().entity("Country").build();
    }
}
