package com.cgi.d4g.business.model;

import com.cgi.d4g.entity.City;
import com.cgi.d4g.entity.Department;
import com.cgi.d4g.entity.Region;

public class ScoringResultModel {
	private City city;
	private CityDigitalScoringModel cityDigitalScoring;
	private Department department;
	private DepartmentDigitalScoringModel departmentDigitalScoring;
	private Region region;
	private RegionDigitalScoringModel regionDigitalScoring;
	
	
	/**
	 * Constructor of the Scoring Result model
	 * @param city the searched city
	 * @param cityDigitalScoring the result of the scoring
	 * @param department the departmnet of the city
	 * @param departmentDigitalScoring the result of the scoring of departmnet
	 * @param region the region of the city
	 * @param regionDigitalScoring the result of the scoring of region
	 */
	public ScoringResultModel(City city, CityDigitalScoringModel cityDigitalScoring, Department department,
			DepartmentDigitalScoringModel departmentDigitalScoring, Region region,
			RegionDigitalScoringModel regionDigitalScoring) {
		super();
		this.city = city;
		this.cityDigitalScoring = cityDigitalScoring;
		this.department = department;
		this.departmentDigitalScoring = departmentDigitalScoring;
		this.region = region;
		this.regionDigitalScoring = regionDigitalScoring;
	}


	/**
	 * @return the city
	 */
	public City getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(City city) {
		this.city = city;
	}


	/**
	 * @return the cityDigitalScoring
	 */
	public CityDigitalScoringModel getCityDigitalScoring() {
		return cityDigitalScoring;
	}


	/**
	 * @param cityDigitalScoring the cityDigitalScoring to set
	 */
	public void setCityDigitalScoring(CityDigitalScoringModel cityDigitalScoring) {
		this.cityDigitalScoring = cityDigitalScoring;
	}


	/**
	 * @return the department
	 */
	public Department getDepartment() {
		return department;
	}


	/**
	 * @param department the department to set
	 */
	public void setDepartment(Department department) {
		this.department = department;
	}


	/**
	 * @return the departmentDigitalScoring
	 */
	public DepartmentDigitalScoringModel getDepartmentDigitalScoring() {
		return departmentDigitalScoring;
	}


	/**
	 * @param departmentDigitalScoring the departmentDigitalScoring to set
	 */
	public void setDepartmentDigitalScoring(DepartmentDigitalScoringModel departmentDigitalScoring) {
		this.departmentDigitalScoring = departmentDigitalScoring;
	}


	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}


	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}


	/**
	 * @return the regionDigitalScoring
	 */
	public RegionDigitalScoringModel getRegionDigitalScoring() {
		return regionDigitalScoring;
	}


	/**
	 * @param regionDigitalScoring the regionDigitalScoring to set
	 */
	public void setRegionDigitalScoring(RegionDigitalScoringModel regionDigitalScoring) {
		this.regionDigitalScoring = regionDigitalScoring;
	}
	
	
	
}
