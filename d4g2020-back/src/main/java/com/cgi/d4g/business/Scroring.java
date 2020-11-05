package com.cgi.d4g.business;
/**
 *	class to manage the business of scoring. 
 */

import com.cgi.d4g.business.model.RegionDigitalScoringModel;
import com.cgi.d4g.business.model.ScoringResultModel;
import com.cgi.d4g.entity.City;
import com.cgi.d4g.entity.CityDigitalScoring;
import com.cgi.d4g.entity.Departement;
import com.cgi.d4g.entity.DepartementDigitalScoring;
import com.cgi.d4g.entity.Region;

public class Scroring {

	/**
	 * Compute the scoring for a city
	 */
	public ScoringResultModel getOrRetriveScorring(City city) {
		Departement departement = getDepartement(city);
		Region region = getRegion(city);
		
		RegionDigitalScoringModel regionDigitalScoring =  generateRegionDigitalScoring();
		DepartementDigitalScoring departementDigitalScoring = getDepartementScoring(departement);
		CityDigitalScoring cityDigitalScoring = getCityScoring(city);
		
		
		
		return new ScoringResultModel(city, cityDigitalScoring, departement, departementDigitalScoring, region, regionDigitalScoring);
	}

	/**
	 * Retrieve the city scoring for the city
	 * @param city the city to get the scoring
	 * @return the scoring
	 */
	private CityDigitalScoring getCityScoring(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieve the department scoring for the department 
	 * @param department the department
	 * @return the scoring of the department
	 */
	private DepartementDigitalScoring getDepartementScoring(Departement department) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieve the region of the city
	 * @param city the city of the region to search
	 * @return the department of the city 
	 */
	private Region getRegion(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Retrieve the department of the city
	 * @param city the city of the department to search
	 * @return the department of the city 
	 */
	private Departement getDepartement(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
	 * Generate the default value for region
	 * @return the region scoring values
	 */
	private RegionDigitalScoringModel generateRegionDigitalScoring() {
		// FIXME
		return null;
	}
}
