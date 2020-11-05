package com.cgi.d4g.dao;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.Region;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class RegionDAO implements PanacheRepository<Region> {

	/**
	 * Find region by name
	 * @param name the name to find
	 * @return the region
	 */
   public Region findByName(String name){
       return find("RGN_NAME", name).firstResult();
   }
}
