package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.Region;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * Dao of the region
 * @author vaulotan
 *
 */
@ApplicationScoped
public class RegionDAO implements PanacheRepository<Region> {

	/**
	 * list all region order by name
	 * @return the region
	 */
   public List<Region> listAll(){
       return listAll(Sort.ascending("rgnName"));
   }

	/**
	 * Find region by name
	 * @param name the name to find
	 * @return the region
	 */
   public Region findByName(String name){
       return find("RGN_NAME", name).firstResult();
   }
}
