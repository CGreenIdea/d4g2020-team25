package com.cgi.d4g.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "IMP_METROPOLE_SITES", schema = "d4g_ifn", catalog = "")
public class ImpMetropoleSites {
    private long mpsId;
    private String mpsCodeArm;
    private BigDecimal mpsCodeAccessibility2G;

    @Id
    @Column(name = "MPS_ID", nullable = false)
    public long getMpsId() {
        return mpsId;
    }

    public void setMpsId(long mpsId) {
        this.mpsId = mpsId;
    }

    @Basic
    @Column(name = "MPS_CODE_ARM", nullable = false, length = 5)
    public String getMpsCodeArm() {
        return mpsCodeArm;
    }

    public void setMpsCodeArm(String mpsCodeArm) {
        this.mpsCodeArm = mpsCodeArm;
    }

    @Basic
    @Column(name = "MPS_CODE_ACCESSIBILITY_2G", nullable = true, precision = 4)
    public BigDecimal getMpsCodeAccessibility2G() {
        return mpsCodeAccessibility2G;
    }

    public void setMpsCodeAccessibility2G(BigDecimal mpsCodeAccessibility2G) {
        this.mpsCodeAccessibility2G = mpsCodeAccessibility2G;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ImpMetropoleSites that = (ImpMetropoleSites) o;
        return mpsId == that.mpsId &&
            Objects.equals(mpsCodeArm, that.mpsCodeArm) &&
            Objects.equals(mpsCodeAccessibility2G, that.mpsCodeAccessibility2G);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mpsId, mpsCodeArm, mpsCodeAccessibility2G);
    }
}
