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
 * departement reste WS
 * @author vaulotan
 *
 */
@Path("/rest/departement")
@Produces(MediaType.APPLICATION_JSON)
public class DepartementResource {
	
	@Inject
	private DepartementDAO departementDAO;
	
	/**
	 * List of all the departement.
	 * @return list of departement
	 */
    @GET
    public List<Departement> list() {
        return this.departementDAO.listAll();
    }
}
