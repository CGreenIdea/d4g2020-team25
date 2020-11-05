package com.cgi.d4g.dao;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * DAO for the ImpBaseCcFilosofi for Departement 
 * @author vaulotan
 *
 */
@ApplicationScoped
public class ImpBaseCcFilosofiDepartementDAO implements PanacheRepository<ImpBaseCcFilosofiDepartement> {

	/**
	 * Find ImpBaseCcFilosofi for Departement by code
	 * @param code the code to find
	 * @return the ImpBaseCcFilosofi for Departement
	 */
   public ImpBaseCcFilosofiDepartement get(String code){
       return find("FLD_CODE", code).firstResult();
   }
}