package com.cgi.d4g.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import com.cgi.d4g.dto.ImpBaseIcCouplesFamillesMenagesTo;
import com.cgi.d4g.entity.ImpBaseIcCouplesFamillesMenages;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

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
   
   
   public ImpBaseIcCouplesFamillesMenagesTo getAvgRegion(long rgnId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(CFM_SINGLE), avg(CFM_SINGLE_PARENT), avg(CFM_HOUSEHOLD) from IMP_BASE_IC_COUPLES_FAMILLES_MENAGES f inner join CITY c on c.CTY_CODE_ARM=f.CFM_CODE_ARM INNER JOIN DEPARTMENT d ON d.DPT_ID = c.DPT_ID where d.RGN_ID = :rgnId");
	   nativeQuery.setParameter("rgnId", 1);
	   Stream<Object[]> resultList = nativeQuery.getResultStream();
	   
	   ImpBaseIcCouplesFamillesMenagesTo impBaseIcCouplesFamillesMenagesTo = new ImpBaseIcCouplesFamillesMenagesTo(); 
	   
	   resultList.forEach((record) -> {
		   BigDecimal cdrSingle = (BigDecimal) record[0];
		   BigDecimal cdrSingleParent = (BigDecimal) record[1];
		   impBaseIcCouplesFamillesMenagesTo.setCdrSingle(cdrSingle);
		   impBaseIcCouplesFamillesMenagesTo.setCdrSingleParent(cdrSingleParent);
		   impBaseIcCouplesFamillesMenagesTo.setCfm_household((BigDecimal) record[2]);
	});
	   return impBaseIcCouplesFamillesMenagesTo;
   }
   
   
   public ImpBaseIcCouplesFamillesMenagesTo getAvgdepartment(long dptId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(CFM_SINGLE), avg(CFM_SINGLE_PARENT), avg(CFM_HOUSEHOLD) from IMP_BASE_IC_COUPLES_FAMILLES_MENAGES f inner join CITY c on c.CTY_CODE_ARM=f.CFM_CODE_ARM where c.DPT_ID = :dptId");
	   nativeQuery.setParameter("dptId", 1);
	   Stream<Object[]> resultList = nativeQuery.getResultStream();

	   ImpBaseIcCouplesFamillesMenagesTo impBaseIcCouplesFamillesMenagesTo = new ImpBaseIcCouplesFamillesMenagesTo(); 
	   
	   resultList.forEach((record) -> {
		   BigDecimal cdrSingle = (BigDecimal) record[0];
		   BigDecimal cdrSingleParent = (BigDecimal) record[1];
		   impBaseIcCouplesFamillesMenagesTo.setCdrSingle(cdrSingle);
		   impBaseIcCouplesFamillesMenagesTo.setCdrSingleParent(cdrSingleParent);
		   impBaseIcCouplesFamillesMenagesTo.setCfm_household((BigDecimal) record[2]);
	});
	   return impBaseIcCouplesFamillesMenagesTo;
   }
   
   
}