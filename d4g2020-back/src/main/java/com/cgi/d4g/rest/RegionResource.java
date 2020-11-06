package com.cgi.d4g.rest;

import java.util.List;

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
	 * The region DAO.
	 */
	private final RegionDAO regionDao;

	/**
	 * The city DAO
	 */
	private final CityDAO cityDao;

	/**
	 * Constructor
	 * @param regionDao the region DAO
	 * @param cityDao the city DAO
	 */
    public RegionResource(RegionDAO regionDao, CityDAO cityDao) {
		this.regionDao = regionDao;
		this.cityDao = cityDao;
	}

    /**
     * list all the region
     * @return the region list
     */
	@GET
    public List<Region> listAll() {
        return this.regionDao.listAll();
    }

	/**
	 * List of all the city of a region.
	 * @param regionId the id of the region to filter
	 * @param name the name to filter
	 * @return list of city
	 */
    @GET
    @Path("{regionId}/department/{departmentId}/city/name/{name}")
    public List<City> listCity(@PathParam("regionId") int regionId, @PathParam("departmentId") int departmentId, @PathParam("name") String name) {
        if (departmentId >= 0) {
            return this.cityDao.listByDepartmentName(departmentId, name);
        } else if (regionId >= 0) {
            return this.cityDao.listByRegionAndName(regionId, name);
        }

        return this.cityDao.listByName(name);
    }
}
