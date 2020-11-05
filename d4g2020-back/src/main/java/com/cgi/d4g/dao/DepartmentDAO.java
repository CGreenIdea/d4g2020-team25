package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.Department;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

/**
 * DAO for the department
 * @author vaulotan
 *
 */
@ApplicationScoped
public class DepartmentDAO implements PanacheRepository<Department> {

	/**
	 * list all departement order by postal code
	 * @param name the name to find
	 * @return the departement
	 */
   public List<Department> listAll(){
       return listAll(Sort.ascending("dptCode"));
   }
}
