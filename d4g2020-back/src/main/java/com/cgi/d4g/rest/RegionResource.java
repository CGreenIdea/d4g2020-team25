package com.cgi.d4g.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cgi.d4g.dao.CityDAO;
import com.cgi.d4g.dao.RegionDAO;
import com.cgi.d4g.entity.City;
import com.cgi.d4g.entity.Region;

/**
 * Rest Region resource
 * @author vaulotan
 *
 */
@Path("/rest/region")
@Produces(MediaType.APPLICATION_JSON)
public class RegionResource {
	
	/**
	 * the region DAO.
	 */
	private final RegionDAO regionDAO;
	
	/**
	 * constructeur
	 * @param cityDao the city Dao
	 */
    public RegionResource(RegionDAO regionDAO) {
		this.regionDAO = regionDAO;
	}

	@GET
    public List<Region> listAll() {
        return this.regionDAO.listAll();
    }
}
