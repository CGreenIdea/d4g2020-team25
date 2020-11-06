package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;
import com.cgi.d4g.entity.ImpBaseIcEvolStructProp;
import com.cgi.d4g.entity.ImpHdThdDeploiement;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the ImpHdThdDeploiementDAO for hd data
 * @author fduc
 *
 */
@ApplicationScoped
public class ImpHdThdDeploiementDAO implements PanacheRepository<ImpHdThdDeploiement> {

	/**
	 * Find list of hd values for city code
	 * @param code the city code
	 * @return the list of hd data
	 */
   public List<ImpHdThdDeploiement> getByCode(String code){
       return list("HTD_CODE_ARM", code);
   }
}