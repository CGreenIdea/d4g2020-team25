package com.cgi.d4g.business;
/**
 *	class to manage the business of scoring. 
 */

import java.math.BigDecimal;

import com.cgi.d4g.business.model.RegionDigitalScoringModel;
import com.cgi.d4g.business.model.ScoringResultModel;
import com.cgi.d4g.entity.City;
import com.cgi.d4g.entity.CityDigitalScoring;
import com.cgi.d4g.entity.Department;
import com.cgi.d4g.entity.DepartmentDigitalScoring;
import com.cgi.d4g.entity.Region;

public class Scroring {

	/**
	 * Compute the scoring for a city
	 * @param city the city where the scoring is requested.
	 */
	public ScoringResultModel getOrRetriveScorring(City city) {
		Department department = getDepartment(city);
		Region region = getRegion(city);
		
		RegionDigitalScoringModel regionDigitalScoring =  generateRegionDigitalScoring();
		DepartmentDigitalScoring departmentDigitalScoring = getDepartmentScoring(department);
		CityDigitalScoring cityDigitalScoring = getCityScoring(city);
		
		
		
		return new ScoringResultModel(city, cityDigitalScoring, department, departmentDigitalScoring, region, regionDigitalScoring);
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
	private DepartmentDigitalScoring getDepartmentScoring(Department department) {
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
	private Department getDepartment(City city) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/**
	 * Generate the default value for region
	 * @return the region scoring values
	 */
	private RegionDigitalScoringModel generateRegionDigitalScoring() {
		// FIXME 
		int cdrDepartmentId = 0;
		Integer cdrLegalPopulation = null;
		Integer cdrSingle = null;
		Integer cdrPersonAged15To29= null;
		Integer cdrNoDiplomaOver15= null;
		Integer cdrJobless15To64= null;
		Integer cdrSingleParent= null;
		Integer cdrPersonAgedOver65= null;
		BigDecimal cdrMedianIncome= null;
		BigDecimal cdrPovertyRate= null;
		BigDecimal cdrPublicService= null;
		BigDecimal cdrPublicServicePerPerson= null;
		BigDecimal cdrMobilityCoverageRate2G= null;
		BigDecimal cdrNetworkRateCoverage= null;
		return new RegionDigitalScoringModel(cdrLegalPopulation, cdrNetworkRateCoverage, cdrMobilityCoverageRate2G, cdrPovertyRate, cdrMedianIncome, cdrSingleParent, cdrSingle, cdrPublicServicePerPerson, cdrPublicService, cdrJobless15To64, cdrPersonAged15To29, cdrPersonAgedOver65, cdrNoDiplomaOver15, cdrDepartmentId);
	}
}
