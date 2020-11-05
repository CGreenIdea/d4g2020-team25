package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;
import com.cgi.d4g.entity.ImpBaseIcCouplesFamillesMenages;
import com.cgi.d4g.entity.ImpBaseIcEvolStructProp;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the ImpBaseIcEvolStructPropDAO for family data
 * @author fduc
 *
 */
@ApplicationScoped
public class ImpBaseIcCouplesFamillesMenagesDAO implements PanacheRepository<ImpBaseIcCouplesFamillesMenages> {

	/**
	 * Find list of family data values for city code
	 * @param code the city code
	 * @return the list of family data
	 */
   public List<ImpBaseIcCouplesFamillesMenages> getByCode(String code){
       return list("CFM_CODE_ARM", code);
   }
}