package com.cgi.d4g.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cgi.d4g.dao.CityDAO;
import com.cgi.d4g.entity.City;

@Path("/rest/city")
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {
	
	/**
	 * the city DAO
	 */
	private CityDAO cityDAO;
	
    /**
     * Constructor
	 * @param cityDAO
	 */
	public CityResource(CityDAO cityDAO) {
		this.cityDAO = cityDAO;
	}



	@Path("/name/{name}")
    @GET
    public List<City> listByNameLike(@PathParam("name") String name) {
        return this.cityDAO.listByName(name);
    }
}
