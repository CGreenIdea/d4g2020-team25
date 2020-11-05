package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;
import com.cgi.d4g.entity.ImpBaseIcEvolStructProp;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the ImpBaseIcEvolStructPropDAO for population
 * @author fduc
 *
 */
@ApplicationScoped
public class ImpBaseIcEvolStructPropDAO implements PanacheRepository<ImpBaseIcEvolStructProp> {

	/**
	 * Find list of population values for city code
	 * @param code the city code
	 * @return the list of population
	 */
   public List<ImpBaseIcEvolStructProp> getByCode(String code){
       return list("ESP_CODE_ARM", code);
   }
}