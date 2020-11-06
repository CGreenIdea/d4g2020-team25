package com.cgi.d4g.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import com.cgi.d4g.dto.ImpBaseIcEvolStructPropTo;
import com.cgi.d4g.entity.ImpBaseIcEvolStructProp;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

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
   
   
   public ImpBaseIcEvolStructPropTo getAvgRegion(long rgnId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(ESP_TOTAL_POP), avg(ESP_POP_AGE_15_29), avg(ESP_POP_AGE_OVER_65), avg(ESP_POP_NO_JOB_OVER_15), avg(ESP_POP_AGE_0_14) from IMP_BASE_IC_EVOL_STRUCT_PROP f inner join CITY c on c.CTY_CODE_ARM=f.ESP_CODE_ARM INNER JOIN DEPARTMENT d ON d.DPT_ID = c.DPT_ID where d.RGN_ID = :rgnId");
	   nativeQuery.setParameter("rgnId", 1);
	   Stream<Object[]> resultList = nativeQuery.getResultStream();
	   
	   ImpBaseIcEvolStructPropTo impBaseIcEvolStructPropTo = new ImpBaseIcEvolStructPropTo();
	   resultList.forEach((record) -> {
		   
		   impBaseIcEvolStructPropTo.setEspTotalPop((BigDecimal) record[0]);
		   impBaseIcEvolStructPropTo.setEspPopAge1529((BigDecimal) record[1]);
		   impBaseIcEvolStructPropTo.setEspPopAgeOver65((BigDecimal) record[2]);
		   impBaseIcEvolStructPropTo.setEspPopNoJobOver15((BigDecimal) record[3]);
		   impBaseIcEvolStructPropTo.setEspPopAge014((BigDecimal) record[4]);
		   
	});
	   return impBaseIcEvolStructPropTo;
   }
   
   
   public ImpBaseIcEvolStructPropTo getAvgdepartment(long dptId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(ESP_TOTAL_POP), avg(ESP_POP_AGE_15_29), avg(ESP_POP_AGE_OVER_65), avg(ESP_POP_NO_JOB_OVER_15), avg(ESP_POP_AGE_0_14) from IMP_BASE_IC_EVOL_STRUCT_PROP f inner join CITY c on c.CTY_CODE_ARM=f.ESP_CODE_ARM where c.DPT_ID = :dptId");
	   nativeQuery.setParameter("dptId", 1);
	   Stream<Object[]> resultList = nativeQuery.getResultStream();
	   
	   ImpBaseIcEvolStructPropTo impBaseIcEvolStructPropTo = new ImpBaseIcEvolStructPropTo();
	   resultList.forEach((record) -> {
		   
		   impBaseIcEvolStructPropTo.setEspTotalPop((BigDecimal) record[0]);
		   impBaseIcEvolStructPropTo.setEspPopAge1529((BigDecimal) record[1]);
		   impBaseIcEvolStructPropTo.setEspPopAgeOver65((BigDecimal) record[2]);
		   impBaseIcEvolStructPropTo.setEspPopNoJobOver15((BigDecimal) record[3]);
		   impBaseIcEvolStructPropTo.setEspPopAge014((BigDecimal) record[4]);
		   
	});
	   return impBaseIcEvolStructPropTo;
   }
   
   
}