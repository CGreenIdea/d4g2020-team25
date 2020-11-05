package com.cgi.d4g.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cgi.d4g.dao.CityDAO;
import com.cgi.d4g.dao.DepartementDAO;
import com.cgi.d4g.entity.City;
import com.cgi.d4g.entity.Departement;

/**
 * Department rest WS
 * @author vaulotan
 *
 */
@Path("/rest/department")
@Produces(MediaType.APPLICATION_JSON)
public class DepartementResource {
	
	/**
	 * Constructor
	 * @param departementDAO the department DAO 
	 * @param cityDao the city Dao
	 */
	public DepartementResource(DepartementDAO departementDAO, CityDAO cityDao) {
		this.departementDAO=departementDAO;
		this.cityDao=cityDao;
	}
	
	private final DepartementDAO departementDAO;
	
	private final CityDAO cityDao;
	
	/**
	 * List of all the department.
	 * @return list of department
	 */
    @GET
    public List<Departement> list() {
        return this.departementDAO.listAll();
    }
    
	/**
	 * List of all the city of a department.
	 * @return list of city
	 */
    @GET
    @Path("{departmentId}/city/name/{name}")
    public List<City> listCity(@PathParam("departmentId") int departmentId, @PathParam("name") String name) {
        return this.cityDao.listByDepartmentName(departmentId, name);
    }
}
