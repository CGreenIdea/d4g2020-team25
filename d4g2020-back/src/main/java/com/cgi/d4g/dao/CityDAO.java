package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.City;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the city
 * @author vaulotan
 *
 */
@ApplicationScoped
public class CityDAO implements PanacheRepository<City> {

	/**
	 * Find city by name
	 * @param name the name to find
	 * @return the city
	 */
   public List<City>  listByName(String name){
       return list("CTY_NAME like ?1", Sort.ascending("CTY_NAME"), "%" + name + "%");
   }

	/**
	 * Find city by name
	 * @param dptId the id of the department
	 * @return the city
	 */
	 public List<City>  listByDepartmentName(int dptId){
	     return list("dptId = ?1", Sort.ascending("CTY_NAME"), dptId);
	 }

	/**
	 * Find city by name
	 * @param dptId the id of the department
	 * @param name the name to find
	 * @return the city
	 */
  public List<City>  listByDepartmentName(int dptId ,String name){
      return list("dptId = ?1 and CTY_NAME like ?2", Sort.ascending("CTY_NAME"), dptId, "%" + name + "%");
  }

	/**
	 * Find city by name
	 * @param rgnId the id of the region
	 * @param name the name to find
	 * @return the city
	 */
  	public List<City>  listByRegionName(int rgnId ,String name){
  		return list("select distinct c from City INNER JOIN DEPARTMENT d ON d.dptId = c.dptId where rgnId = ?1 and CTY_NAME like ?2", Sort.ascending("CTY_NAME"), rgnId, "%" + name + "%");
  	}
}