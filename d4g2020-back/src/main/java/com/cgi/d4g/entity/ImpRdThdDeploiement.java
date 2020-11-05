package com.cgi.d4g.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "IMP_RD_THD_DEPLOIEMENT", schema = "d4g_ifn", catalog = "")
public class ImpRdThdDeploiement {
    private long htdId;
    private String htdCodeArm;
    private Integer htdAvailableNetworks;
    private BigDecimal htdBestRate;

    @Id
    @Column(name = "HTD_ID", nullable = false)
    public long getHtdId() {
        return htdId;
    }

    public void setHtdId(long htdId) {
        this.htdId = htdId;
    }

    @Basic
    @Column(name = "HTD_CODE_ARM", nullable = false, length = 5)
    public String getHtdCodeArm() {
        return htdCodeArm;
    }

    public void setHtdCodeArm(String htdCodeArm) {
        this.htdCodeArm = htdCodeArm;
    }

    @Basic
    @Column(name = "HTD_AVAILABLE_NETWORKS", nullable = true)
    public Integer getHtdAvailableNetworks() {
        return htdAvailableNetworks;
    }

    public void setHtdAvailableNetworks(Integer htdAvailableNetworks) {
        this.htdAvailableNetworks = htdAvailableNetworks;
    }

    @Basic
    @Column(name = "HTD_BEST_RATE", nullable = true, precision = 4)
    public BigDecimal getHtdBestRate() {
        return htdBestRate;
    }

    public void setHtdBestRate(BigDecimal htdBestRate) {
        this.htdBestRate = htdBestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImpRdThdDeploiement that = (ImpRdThdDeploiement) o;
        return htdId == that.htdId &&
            Objects.equals(htdCodeArm, that.htdCodeArm) &&
            Objects.equals(htdAvailableNetworks, that.htdAvailableNetworks) &&
            Objects.equals(htdBestRate, that.htdBestRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(htdId, htdCodeArm, htdAvailableNetworks, htdBestRate);
    }
}
