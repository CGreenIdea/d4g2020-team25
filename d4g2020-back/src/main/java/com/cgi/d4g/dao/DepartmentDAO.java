package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.Departement;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the departement
 * @author vaulotan
 *
 */
@ApplicationScoped
public class DepartementDAO implements PanacheRepository<Departement> {

	/**
	 * list all departement order by postal code
	 * @param name the name to find
	 * @return the departement
	 */
   public List<Departement> listAll(){
       return listAll(Sort.ascending("dptCode"));
   }
}
