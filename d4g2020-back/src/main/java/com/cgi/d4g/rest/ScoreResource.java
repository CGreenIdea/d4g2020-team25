package com.cgi.d4g.rest;

import java.math.BigDecimal;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cgi.d4g.business.model.RegionDigitalScoringModel;
import com.cgi.d4g.business.model.ScoringResultModel;
import com.cgi.d4g.dao.CityDAO;
import com.cgi.d4g.dao.DepartmentDAO;
import com.cgi.d4g.dao.ImpBaseIcCouplesFamillesMenagesDAO;
import com.cgi.d4g.dao.RegionDAO;
import com.cgi.d4g.entity.City;
import com.cgi.d4g.entity.CityDigitalScoring;
import com.cgi.d4g.entity.Department;
import com.cgi.d4g.entity.DepartmentDigitalScoring;
import com.cgi.d4g.entity.Region;

@Path("/rest/score")
@Produces(MediaType.APPLICATION_JSON)
public class ScoreResource {
	
	private final CityDAO cityDAO;
	private final DepartmentDAO departmentDAO;
	private final RegionDAO regionDAO;
	private final ImpBaseIcCouplesFamillesMenagesDAO impBaseIcCouplesFamillesMenagesDAO;
    
	/**
	 * @param cityDAO
	 */
	public ScoreResource(CityDAO cityDAO, DepartmentDAO departmentDAO, RegionDAO regionDAO,
			ImpBaseIcCouplesFamillesMenagesDAO impBaseIcCouplesFamillesMenagesDAO) {
		this.cityDAO = cityDAO;
		this.departmentDAO= departmentDAO;
		this.regionDAO=regionDAO;
		this.impBaseIcCouplesFamillesMenagesDAO=impBaseIcCouplesFamillesMenagesDAO;
	}

	/**
	 * List of all the city of a region.
	 * @param regionId the id of the region to filter
	 * @param name the name to filter
	 * @return list of city
	 */
    @GET
    @Path("/city/{cityId}")
    public ScoringResultModel getScoreByCity(@PathParam("cityId") long cityId) {
    	//TODO implemeter l'appel.
    	
    	City city=cityDAO.findById(cityId);
		CityDigitalScoring cityDigitalScoring = new CityDigitalScoring();
		cityDigitalScoring.setCdsDigitalInterface(BigDecimal.valueOf(25.36));
		cityDigitalScoring.setCdsInformationAccess(BigDecimal.valueOf(321.21));
		cityDigitalScoring.setCdsAdministrationSkill(BigDecimal.valueOf(324.2));
		cityDigitalScoring.setCdsDigitalSkill(BigDecimal.valueOf(5.3214));
		
		Department department = departmentDAO.findById(city.getDptId());
		DepartmentDigitalScoring departmentDigitalScoring = new DepartmentDigitalScoring();
		departmentDigitalScoring.setCddDigitalInterface(BigDecimal.valueOf(25.36));
		departmentDigitalScoring.setCddInformationAccess(BigDecimal.valueOf(56.21));
		departmentDigitalScoring.setCddAdministrationSkill(BigDecimal.valueOf(57.2));
		departmentDigitalScoring.setCddDigitalSkill(BigDecimal.valueOf(5.755));
		
		Region region = regionDAO.findById(department.getRgnId());
		RegionDigitalScoringModel regionDigitalScoring = new RegionDigitalScoringModel();
		regionDigitalScoring.setCdrDigitalInterface(BigDecimal.valueOf(555.45));
		regionDigitalScoring.setCdrInformationAccess(BigDecimal.valueOf(57.21));
		regionDigitalScoring.setCdrAdministrationSkill(BigDecimal.valueOf(57.2));
		regionDigitalScoring.setCdrDigitalSkill(BigDecimal.valueOf(5.7));
		
		return new ScoringResultModel(city, cityDigitalScoring, department, departmentDigitalScoring, region, regionDigitalScoring);
    }

	/**
	 * List of all the city of a region.
	 * @param regionId the id of the region to filter
	 * @param name the name to filter
	 * @return list of city
	 */
    @GET
    @Path("/test/{rgnId}")
    public DepartmentDigitalScoring getScoreByregion(@PathParam("rgnId") long rgnId) {
    	DepartmentDigitalScoring regionDigitalScoringModel = impBaseIcCouplesFamillesMenagesDAO.getAvgdepartment(rgnId);
    	
    return regionDigitalScoringModel;
    }

}
