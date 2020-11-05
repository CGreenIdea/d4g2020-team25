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
		CityDigitalScoring cityDigitalScoring = null;
		Departement departement = null;
		DepartementDigitalScoring departementDigitalScoring = null;
		Region region = null;
		RegionDigitalScoringModel regionDigitalScoring = null;
		
		return new ScoringResultModel(city, cityDigitalScoring, departement, departementDigitalScoring, region, regionDigitalScoring);
	}
}
