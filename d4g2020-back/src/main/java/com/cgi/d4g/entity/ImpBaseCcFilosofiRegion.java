package com.cgi.d4g.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "IMP_BASE_CC_FILOSOFI_REGION", schema = "d4g_ifn", catalog = "")
public class ImpBaseCcFilosofiRegion {
    private long flrId;
    private String flrCode;
    private BigDecimal flrPovertyRate;
    private BigDecimal flrMedianIncome;

    @Id
    @Column(name = "FLR_ID", nullable = false)
    public long getFlrId() {
        return flrId;
    }

    public void setFlrId(long flrId) {
        this.flrId = flrId;
    }

    @Basic
    @Column(name = "FLR_CODE", nullable = false, length = 5)
    public String getFlrCode() {
        return flrCode;
    }

    public void setFlrCode(String flrCode) {
        this.flrCode = flrCode;
    }

    @Basic
    @Column(name = "FLR_POVERTY_RATE", nullable = true, precision = 4)
    public BigDecimal getFlrPovertyRate() {
        return flrPovertyRate;
    }

    public void setFlrPovertyRate(BigDecimal flrPovertyRate) {
        this.flrPovertyRate = flrPovertyRate;
    }

    @Basic
    @Column(name = "FLR_MEDIAN_INCOME", nullable = true, precision = 4)
    public BigDecimal getFlrMedianIncome() {
        return flrMedianIncome;
    }

    public void setFlrMedianIncome(BigDecimal flrMedianIncome) {
        this.flrMedianIncome = flrMedianIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImpBaseCcFilosofiRegion that = (ImpBaseCcFilosofiRegion) o;
        return flrId == that.flrId &&
            Objects.equals(flrCode, that.flrCode) &&
            Objects.equals(flrPovertyRate, that.flrPovertyRate) &&
            Objects.equals(flrMedianIncome, that.flrMedianIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flrId, flrCode, flrPovertyRate, flrMedianIncome);
    }
}
