package com.cgi.d4g.dto;

import java.math.BigDecimal;

public class ImpHdThdDeploiementTo {
    private BigDecimal htdAvailableNetworks;
    private BigDecimal htdBestRate;
	/**
	 * @return the htdAvailableNetworks
	 */
	public BigDecimal getHtdAvailableNetworks() {
		return htdAvailableNetworks;
	}
	/**
	 * @param htdAvailableNetworks the htdAvailableNetworks to set
	 */
	public void setHtdAvailableNetworks(BigDecimal htdAvailableNetworks) {
		this.htdAvailableNetworks = htdAvailableNetworks;
	}
	/**
	 * @return the htdBestRate
	 */
	public BigDecimal getHtdBestRate() {
		return htdBestRate;
	}
	/**
	 * @param htdBestRate the htdBestRate to set
	 */
	public void setHtdBestRate(BigDecimal htdBestRate) {
		this.htdBestRate = htdBestRate;
	}

}
