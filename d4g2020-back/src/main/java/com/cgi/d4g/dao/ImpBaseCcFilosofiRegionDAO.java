package com.cgi.d4g.dao;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;
import com.cgi.d4g.entity.ImpBaseCcFilosofiRegion;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * DAO for the ImpBaseCcFilosofi for Region 
 * @author vaulotan
 *
 */
@ApplicationScoped
public class ImpBaseCcFilosofiRegionDAO implements PanacheRepository<ImpBaseCcFilosofiRegion> {

	/**
	 * Find ImpBaseCcFilosofi for Region by code
	 * @param code the code to find
	 * @return the ImpBaseCcFilosofi for Region
	 */
   public ImpBaseCcFilosofiRegion getByCode(String code){
       return find("FLR_CODE", code).firstResult();
   }
}