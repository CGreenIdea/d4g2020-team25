package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;
import com.cgi.d4g.entity.ImpBaseIcDiplomesFormation;
import com.cgi.d4g.entity.ImpBaseIcEvolStructProp;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the ImpBaseIcDiplomesFormationDAO for training data
 * @author fduc
 *
 */
@ApplicationScoped
public class ImpBaseIcDiplomesFormationDAO implements PanacheRepository<ImpBaseIcDiplomesFormation> {

	/**
	 * Find list of training data values for city code
	 * @param code the city code
	 * @return the list of training data
	 */
   public List<ImpBaseIcDiplomesFormation> getByCode(String code){
       return list("DLF_CODE_ARM", code);
   }
}