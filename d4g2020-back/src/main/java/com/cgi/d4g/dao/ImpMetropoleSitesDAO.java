package com.cgi.d4g.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import com.cgi.d4g.dto.ImpHdThdDeploiementTo;
import com.cgi.d4g.dto.ImpMetropoleSitesTo;
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
   
   public ImpMetropoleSitesTo getAvgRegion(long rgnId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(MPS_CODE_ACCESSIBILITY_2G) from IMP_METROPOLE_SITES f inner join CITY c on c.CTY_CODE_ARM=f.MPS_CODE_ARM INNER JOIN DEPARTMENT d ON d.DPT_ID = c.DPT_ID where d.RGN_ID = :rgnId");
	   nativeQuery.setParameter("rgnId", 1);
	   Stream<Object> resultList = nativeQuery.getResultStream();
	   
	   ImpMetropoleSitesTo impMetropoleSitesTo = new ImpMetropoleSitesTo();
	   resultList.forEach((record) -> {
		   impMetropoleSitesTo.setMpsCodeAccessibility2G((BigDecimal) record);
		   
	});
	   return impMetropoleSitesTo;
   }
   
   
   public ImpMetropoleSitesTo getAvgdepartment(long dptId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(MPS_CODE_ACCESSIBILITY_2G) from IMP_METROPOLE_SITES f inner join CITY c on c.CTY_CODE_ARM=f.MPS_CODE_ARM where c.DPT_ID = :dptId");
	   nativeQuery.setParameter("dptId", 1);
	   Stream<Object> resultList = nativeQuery.getResultStream();
	   
	   ImpMetropoleSitesTo impMetropoleSitesTo = new ImpMetropoleSitesTo();
	   resultList.forEach((record) -> {
		   impMetropoleSitesTo.setMpsCodeAccessibility2G((BigDecimal) record);
		   
	});
	   return impMetropoleSitesTo;
   }
}