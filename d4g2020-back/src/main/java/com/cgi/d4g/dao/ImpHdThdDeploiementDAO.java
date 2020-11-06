package com.cgi.d4g.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import com.cgi.d4g.dto.ImpBaseIcEvolStructPropTo;
import com.cgi.d4g.dto.ImpHdThdDeploiementTo;
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
   
   public ImpHdThdDeploiementTo getAvgRegion(long rgnId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(HTD_AVAILABLE_NETWORKS), avg(HTD_BEST_RATE) from IMP_HD_THD_DEPLOIEMENT f inner join CITY c on c.CTY_CODE_ARM=f.HTD_CODE_ARM INNER JOIN DEPARTMENT d ON d.DPT_ID = c.DPT_ID where d.RGN_ID = :rgnId");
	   nativeQuery.setParameter("rgnId", 1);
	   Stream<Object[]> resultList = nativeQuery.getResultStream();
	   
	   ImpHdThdDeploiementTo impHdThdDeploiementTo = new ImpHdThdDeploiementTo();
	   resultList.forEach((record) -> {
		   
		   impHdThdDeploiementTo.setHtdAvailableNetworks((BigDecimal) record[0]);
		   impHdThdDeploiementTo.setHtdBestRate((BigDecimal) record[1]);
		   
	});
	   return impHdThdDeploiementTo;
   }
   
   
   public ImpHdThdDeploiementTo getAvgdepartment(long dptId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(HTD_AVAILABLE_NETWORKS), avg(HTD_BEST_RATE) from IMP_HD_THD_DEPLOIEMENT f inner join CITY c on c.CTY_CODE_ARM=f.HTD_CODE_ARM where c.DPT_ID = :dptId");
	   nativeQuery.setParameter("dptId", 1);
	   Stream<Object[]> resultList = nativeQuery.getResultStream();
	   
	   ImpHdThdDeploiementTo impHdThdDeploiementTo = new ImpHdThdDeploiementTo();
	   resultList.forEach((record) -> {
		   
		   impHdThdDeploiementTo.setHtdAvailableNetworks((BigDecimal) record[0]);
		   impHdThdDeploiementTo.setHtdBestRate((BigDecimal) record[1]);
		   
	});
	   return impHdThdDeploiementTo;
   }
}