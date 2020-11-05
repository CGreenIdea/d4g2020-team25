package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.City;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class CityDAO implements PanacheRepository<City> {

	/**
	 * Find region by name
	 * @param name the name to find
	 * @return the region
	 */
   public List<City>  listByName(String name){
	   System.out.println("name: " + name);
       return list("CTY_NAME like ?1", "%" + name + "%");
   }
}
