package com.cgi.d4g.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.cgi.d4g.entity.ScoringHistory;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

/**
 * DAO for scoring history data
 */
@ApplicationScoped
public class ScoringHistoryDAO implements PanacheRepository<ScoringHistory> {

	/**
	 * Find all Scoring history
	 * @return the list of all history
	 */
   public List<ScoringHistory> listAll(){
       return listAll(null);
   }
}
