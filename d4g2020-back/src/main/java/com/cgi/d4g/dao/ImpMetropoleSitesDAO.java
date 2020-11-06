package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;
import com.cgi.d4g.entity.ImpBaseIcEvolStructProp;
import com.cgi.d4g.entity.ImpMetropoleSites;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the ImpBaseIcEvolStructPropDAO for mobile data
 * @author fduc
 *
 */
@ApplicationScoped
public class ImpMetropoleSitesDAO implements PanacheRepository<ImpMetropoleSites> {

	/**
	 * Find list of population values for city code
	 * @param code the city code
	 * @return the list of population
	 */
   public List<ImpMetropoleSites> getByCode(String code){
       return list("MPS_CODE_ARM", code);
   }
}