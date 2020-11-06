package com.cgi.d4g.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.Query;

import com.cgi.d4g.dto.ImpBaseIcDiplomesFormationTo;
import com.cgi.d4g.entity.ImpBaseIcDiplomesFormation;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

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


   public ImpBaseIcDiplomesFormationTo getAvgRegion(long rgnId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select sum(DLF_UNSCHOLAR_OVER_15), sum(DLF_UNSCHOLAR_NO_DIPLOMA_OVER_15) from IMP_BASE_IC_DIPLOMES_FORMATION f inner join CITY c on c.CTY_CODE_ARM=f.DLF_CODE_ARM INNER JOIN DEPARTMENT d ON d.DPT_ID = c.DPT_ID where d.RGN_ID = :rgnId");
	   nativeQuery.setParameter("rgnId", 1);
	   Stream<Object[]> resultList = nativeQuery.getResultStream();

	   ImpBaseIcDiplomesFormationTo impBaseIcDiplomesFormationTo = new ImpBaseIcDiplomesFormationTo();
	   resultList.forEach((record) -> {

		   impBaseIcDiplomesFormationTo.setDlfUnscholarOver15(((BigDecimal ) record[1]).intValue());
		   impBaseIcDiplomesFormationTo.setDlfUnscholarNoDiplomaOver15(((BigDecimal ) record[0]).intValue());

	});
	   return impBaseIcDiplomesFormationTo;
   }


   public ImpBaseIcDiplomesFormationTo getAvgdepartment(long dptId) {
	   Query nativeQuery = this.getEntityManager().createNativeQuery("select avg(DLF_UNSCHOLAR_OVER_15), avg(DLF_UNSCHOLAR_NO_DIPLOMA_OVER_15) from IMP_BASE_IC_DIPLOMES_FORMATION f inner join CITY c on c.CTY_CODE_ARM=f.DLF_CODE_ARM where c.DPT_ID = :dptId");
	   nativeQuery.setParameter("dptId", 1);
	   Stream<Object[]> resultList = nativeQuery.getResultStream();

	   ImpBaseIcDiplomesFormationTo impBaseIcDiplomesFormationTo = new ImpBaseIcDiplomesFormationTo();
	   resultList.forEach((record) -> {

		   impBaseIcDiplomesFormationTo.setDlfUnscholarOver15(((BigDecimal ) record[1]).intValue());
		   impBaseIcDiplomesFormationTo.setDlfUnscholarNoDiplomaOver15(((BigDecimal ) record[0]).intValue());

	});
	   return impBaseIcDiplomesFormationTo;
   }
}
