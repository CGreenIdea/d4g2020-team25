package com.cgi.d4g.dto;

import java.math.BigDecimal;

public class ImpBaseIcCouplesFamillesMenagesTo {

	private BigDecimal cdrSingle;
	private BigDecimal cdrSingleParent;
	private BigDecimal cfm_household;
	
	/**
	 * @return the cfm_household
	 */
	public BigDecimal getCfm_household() {
		return cfm_household;
	}
	/**
	 * @param cfm_household the cfm_household to set
	 */
	public void setCfm_household(BigDecimal cfm_household) {
		this.cfm_household = cfm_household;
	}
	/**
	 * @return the cdrSingle
	 */
	public BigDecimal getCdrSingle() {
		return cdrSingle;
	}
	/**
	 * @param cdrSingle the cdrSingle to set
	 */
	public void setCdrSingle(BigDecimal cdrSingle) {
		this.cdrSingle = cdrSingle;
	}
	/**
	 * @return the cdrSingleParent
	 */
	public BigDecimal getCdrSingleParent() {
		return cdrSingleParent;
	}
	/**
	 * @param cdrSingleParent the cdrSingleParent to set
	 */
	public void setCdrSingleParent(BigDecimal cdrSingleParent) {
		this.cdrSingleParent = cdrSingleParent;
	}
	
	
}
