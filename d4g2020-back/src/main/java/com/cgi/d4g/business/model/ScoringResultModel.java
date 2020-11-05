package com.cgi.d4g.business.model;

import com.cgi.d4g.entity.City;
import com.cgi.d4g.entity.CityDigitalScoring;
import com.cgi.d4g.entity.Departement;
import com.cgi.d4g.entity.DepartementDigitalScoring;
import com.cgi.d4g.entity.Region;

public class ScoringResultModel {
	private City city;
	private CityDigitalScoring cityDigitalScoring;
	private Departement departement;
	private DepartementDigitalScoring departementDigitalScoring;
	private Region region;
	private RegionDigitalScoringModel regionDigitalScoring;
	
	
	/**
	 * Constructor of the Scoring Result model
	 * @param city the searched city
	 * @param cityDigitalScoring the result of the scoring
	 * @param departement the departemnet of the city
	 * @param departementDigitalScoring the result of the scoring of departemnet
	 * @param region the region of the city
	 * @param regionDigitalScoring the result of the scoring of region
	 */
	public ScoringResultModel(City city, CityDigitalScoring cityDigitalScoring, Departement departement,
			DepartementDigitalScoring departementDigitalScoring, Region region,
			RegionDigitalScoringModel regionDigitalScoring) {
		super();
		this.city = city;
		this.cityDigitalScoring = cityDigitalScoring;
		this.departement = departement;
		this.departementDigitalScoring = departementDigitalScoring;
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
	public CityDigitalScoring getCityDigitalScoring() {
		return cityDigitalScoring;
	}


	/**
	 * @param cityDigitalScoring the cityDigitalScoring to set
	 */
	public void setCityDigitalScoring(CityDigitalScoring cityDigitalScoring) {
		this.cityDigitalScoring = cityDigitalScoring;
	}


	/**
	 * @return the departement
	 */
	public Departement getDepartement() {
		return departement;
	}


	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	/**
	 * @return the departementDigitalScoring
	 */
	public DepartementDigitalScoring getDepartementDigitalScoring() {
		return departementDigitalScoring;
	}


	/**
	 * @param departementDigitalScoring the departementDigitalScoring to set
	 */
	public void setDepartementDigitalScoring(DepartementDigitalScoring departementDigitalScoring) {
		this.departementDigitalScoring = departementDigitalScoring;
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
