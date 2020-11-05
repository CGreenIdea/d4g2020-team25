package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ImpBaseCcFilosofi;
import com.cgi.d4g.entity.ImpBaseCcFilosofiDepartement;
import com.cgi.d4g.entity.ImpBaseIcEvolStructProp;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the ImpBaseCcFilosofieDAO for poverty/Median
 * @author fduc
 *
 */
@ApplicationScoped
public class ImpBaseCcFilosofieDAO implements PanacheRepository<ImpBaseCcFilosofi> {

	/**
	 * Find list of poverty/Median values for city code
	 * @param code the city code
	 * @return the list poverty/median values
	 */
   public List<ImpBaseCcFilosofi> getByCode(String code){
       return list("FLF_CODE_ARM", code);
   }
}