package com.cgi.d4g;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cgi.d4g.dao.RegionDAO;

@Path("/resteasy/hello")
public class ExampleResource {
	
	@Inject
	private RegionDAO regionDAO;
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @Path("forTest")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String helloBDD() {
        return this.regionDAO.findByName("Guadeloupe").getRgnName();
    }
}
